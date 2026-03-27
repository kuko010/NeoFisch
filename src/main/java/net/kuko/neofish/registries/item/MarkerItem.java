package net.kuko.neofish.registries.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MarkerItem extends Item {
    public MarkerItem(Properties properties) {
        super(properties);
    }


    /*? if 26.1 {*/
    /*@Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        return sharedUse(level, player, hand);
    }*/
    /*?} elif 1.21.1 {*/
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return sharedUse(level, player, hand);
    }
    /*?}*/



    private InteractionResultHolder<ItemStack> sharedUse(Level level, Player player, InteractionHand hand) {


        return super.use(level, player, hand);
    }
}
