package me.japack.evolutionequipments;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

	public static class EvolutionArmorAbstract implements ArmorMaterial{

		private static final int[] BASE_DURABILITY = new int[] {5, 5, 5, 5};
		private static final int[] PROTECTION_VALUES = new int[] {100, 100, 100, 100};
		private int EvolutionIndicator;
		private int EvolutionCap;
		private int EvolutionDurability;
		private String EvolutionName = "evolution";

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
			return 100;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			// TODO Auto-generated method stub
			return 100;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return 1;
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
			return 100;
		}

		@Override
		public float getKnockbackResistance() {
			// TODO Auto-generated method stub
			return 100;
		}

	}


	public class RegisterEvolutionArmor {

		public static final ArmorMaterial EVOLUTION = new EvolutionArmorAbstract(); 
		public static final Item EVOLUTION_HELMET = new ArmorItem(EVOLUTION, EquipmentSlot.HEAD, new Item.Settings().group(evolutionequipments.EVOLUTIONEQUIPMENTS_ITEM_GROUP));
		public static final Item EVOLUTION_CHESTPLATE = new ArmorItem(EVOLUTION, EquipmentSlot.CHEST, new Item.Settings().group(evolutionequipments.EVOLUTIONEQUIPMENTS_ITEM_GROUP));
		public static final Item EVOLUTION_LEGGINGS = new ArmorItem(EVOLUTION, EquipmentSlot.LEGS, new Item.Settings().group(evolutionequipments.EVOLUTIONEQUIPMENTS_ITEM_GROUP));
		public static final Item EVOLUTION_BOOTS = new ArmorItem(EVOLUTION, EquipmentSlot.FEET, new Item.Settings().group(evolutionequipments.EVOLUTIONEQUIPMENTS_ITEM_GROUP));
		public static void register() {	
			Registry.register(Registry.ITEM, new Identifier("evolutionequipments", "evolution_helmet"), EVOLUTION_HELMET);
			Registry.register(Registry.ITEM, new Identifier("evolutionequipments", "evolution_chestplate"), EVOLUTION_CHESTPLATE);
			Registry.register(Registry.ITEM, new Identifier("evolutionequipments", "evolution_leggings"), EVOLUTION_LEGGINGS);
			Registry.register(Registry.ITEM, new Identifier("evolutionequipments", "evolution_boots"), EVOLUTION_BOOTS);
		}
	 
	}

	public static final Item Shield_Battery = new Item(new FabricItemSettings());


	public static final ItemGroup EVOLUTIONEQUIPMENTS_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("evolutionequipments", "general")).icon(() -> new ItemStack(evolutionequipments.Shield_Battery))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(evolutionequipments.Shield_Battery));
			stacks.add(new ItemStack(evolutionequipments.RegisterEvolutionArmor.EVOLUTION_HELMET));
			stacks.add(new ItemStack(evolutionequipments.RegisterEvolutionArmor.EVOLUTION_CHESTPLATE));
			stacks.add(new ItemStack(evolutionequipments.RegisterEvolutionArmor.EVOLUTION_LEGGINGS));
			stacks.add(new ItemStack(evolutionequipments.RegisterEvolutionArmor.EVOLUTION_BOOTS));
		}).build();
	
	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier("evolutionequipments", "shield_battery"), Shield_Battery);
		RegisterEvolutionArmor.register();
		// LOGGER.info("Hello Fabric world!");
	}
}
