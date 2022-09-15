package me.japack.evolutionequipments;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class evolutionequipments implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("evolutionequipments");

	public class EvolutionArmorAbstract implements ArmorMaterial{

		private static final int[] BASE_DURABILITY = new int[] {5, 5, 5, 5};
		private static final int[] PROTECTION_VALUES = new int[] {100, 100, 100, 100};
		private int EvolutionIndicator;
		private int EvolutionCap;
		private int EvolutionDurability;
		private String EvolutionName = "";

		public EvolutionArmorAbstract() {
			EvolutionIndicator = 0;
			EvolutionCap = 1150;
			EvolutionDurability = 15;
		}

		public EvolutionArmorAbstract(int Indicator, int Cap, int Durability) {
			EvolutionIndicator = Indicator;
			EvolutionCap = Cap;
			EvolutionDurability = Durability;
		}

		public void EvolutionIndicatorSetter(int Indicator) {
			EvolutionIndicator = Indicator;
		}

		public void EvolutionCapSetter(int Cap) {
			EvolutionCap = Cap;
		}

		public void EvolutionDurabilitySetter(int Durability) {
			EvolutionDurability = Durability;
		}

		public boolean EvolutionProgress(int Steps) {
			if(EvolutionIndicator >= EvolutionCap) {
				return false;
			}
			if(EvolutionIndicator + Steps >= EvolutionCap) {
				EvolutionIndicator = EvolutionCap;
				return true;
			}
			EvolutionIndicator += Steps;
			return true;
		}

		@Override
		public int getDurability(EquipmentSlot slot) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public SoundEvent getEquipSound() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Ingredient getRepairIngredient() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			return EvolutionName;
		}

		@Override
		public float getToughness() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getKnockbackResistance() {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public static final Item Shield_Battery = new Item(new FabricItemSettings().group(ItemGroup.COMBAT));

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier("evolutionequipments", "shield_battery"), Shield_Battery);


		// LOGGER.info("Hello Fabric world!");
	}
}
