package net.kardiinal.saocrystals.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AntidoteCrystalItem extends Item {
    public AntidoteCrystalItem (Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){

            if(!player.isCreative()){
                decreaseItemStack(player, hand);
            }

            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SPLASH_POTION_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);

            player.removeAllEffects();

        }

        return super.use(level, player, hand);

    }

    void decreaseItemStack(Player player, InteractionHand hand){
        ItemStack itemStack = player.getItemInHand(hand);
        itemStack.setCount(itemStack.getCount() - 1);
        player.getCooldowns().addCooldown(this, getCooldownTime());
    }

    int getCooldownTime(){
        int cooldownTimeInSeconds = 10;
        int cooldownTime = (int)cooldownTimeInSeconds * 20;
        return cooldownTime;
    }


}
