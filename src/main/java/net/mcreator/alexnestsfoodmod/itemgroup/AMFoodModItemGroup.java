
package net.mcreator.alexnestsfoodmod.itemgroup;

@FoodModModElements.ModElement.Tag
public class AMFoodModItemGroup extends FoodModModElements.ModElement {

	public AMFoodModItemGroup(FoodModModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabam_food_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChocoCookieItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}