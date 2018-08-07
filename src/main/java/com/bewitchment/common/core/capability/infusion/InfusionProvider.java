package com.bewitchment.common.core.capability.infusion;

import com.bewitchment.api.infusion.IInfusionCapability;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import static com.bewitchment.api.infusion.IInfusionCapability.CAPABILITY;

public class InfusionProvider implements ICapabilitySerializable<NBTBase> {

	private IInfusionCapability default_capability = CAPABILITY.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CAPABILITY) {
			return CAPABILITY.cast(default_capability);
		}
		return null;
	}

	@Override
	public NBTBase serializeNBT() {
		return CAPABILITY.getStorage().writeNBT(CAPABILITY, default_capability, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		CAPABILITY.getStorage().readNBT(CAPABILITY, default_capability, null, nbt);
	}

}
