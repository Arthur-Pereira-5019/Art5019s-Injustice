package com.art5019.art5019s_injustice.item;

import com.art5019.art5019s_injustice.data.Skill;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.art5019.art5019s_injustice.Art5019sInjustice.ITEMS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;

@Mod(MODID)
public class Items {
    public static final DeferredItem<Item> ENGINEERING_BOOK = ITEMS.registerItem(
            "engineering_book", x -> new SkillBook(bookProperties("engineering_book",new Skill(1,1)))
    );

    public static Item.Properties bookProperties(String name, Skill skill) {
        return new Item.Properties().
                stacksTo(1).
                component(SKILL_COMPONENT, skill).
                setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(MODID,name)));
    }


}
