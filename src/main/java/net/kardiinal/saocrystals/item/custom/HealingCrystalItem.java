package net.kardiinal.saocrystals.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HealingCrystalItem extends Item {
    public HealingCrystalItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            float healPercent = 0.5F;
            float maxHealth = player.getMaxHealth();
            float currentHealth = player.getHealth();
            if(currentHealth < maxHealth){
                if(!player.isCreative()){
                    decreaseItemStack(player, hand);
                }
                float healAmount = maxHealth * healPercent;
                player.heal(healAmount);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SPLASH_POTION_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
            }else{
                player.sendSystemMessage(Component.literal("Cardinal: You cannot use a Healing Crystal with full life!"));
            }
        }

        return super.use(level, player, hand);

    }

    void decreaseItemStack(Player player, InteractionHand hand){
        ItemStack itemStack = player.getItemInHand(hand);
        itemStack.setCount(itemStack.getCount() - 1);
        player.getCooldowns().addCooldown(this, getCooldownTime());
    }

    int getCooldownTime(){
        int cooldownTimeInSeconds = 5;
        int cooldownTime = (int)cooldownTimeInSeconds * 20;
        return cooldownTime;
    }
}
