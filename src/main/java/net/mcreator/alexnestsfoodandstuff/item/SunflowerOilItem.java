
package net.mcreator.alexnestsfoodandstuff.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.alexnestsfoodandstuff.procedures.SunflowerOilCraftedProcedure;
import net.mcreator.alexnestsfoodandstuff.itemgroup.AMFaSItemsItemGroup;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@FoodandstuffModModElements.ModElement.Tag
public class SunflowerOilItem extends FoodandstuffModModElements.ModElement {
	@ObjectHolder("foodandstuff_mod:sunflower_oil")
	public static final Item block = null;
	public SunflowerOilItem(FoodandstuffModModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AMFaSItemsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
			setRegistryName("sunflower_oil");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(Items.GLASS_BOTTLE, (int) (1));
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Useful for frying and making salads."));
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SunflowerOilCraftedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
