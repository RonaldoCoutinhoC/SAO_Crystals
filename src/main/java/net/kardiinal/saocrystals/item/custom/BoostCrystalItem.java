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

public class BoostCrystalItem extends Item {

    public BoostCrystalItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){

            if(!player.isCreative()){
                decreaseItemStack(player, hand);
            }

            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SPLASH_POTION_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);

            applyEffectsToPlayer(player);


        }

        return super.use(level, player, hand);

    }

    void decreaseItemStack(Player player, InteractionHand hand){
        ItemStack itemStack = player.getItemInHand(hand);
        itemStack.setCount(itemStack.getCount() - 1);
        player.getCooldowns().addCooldown(this, getCooldownTime());
    }

    int getCooldownTime(){
        int cooldownTimeInSeconds = 30;
        int cooldownTime = (int)cooldownTimeInSeconds * 20;
        return cooldownTime;
    }

    void applyEffectsToPlayer(Player player){
        int durationInSeconds = 30;
        int duration = (int)durationInSeconds * 20;

        MobEffectInstance speedEffect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, 0);
        MobEffectInstance damageBoostEffect = new MobEffectInstance(MobEffects.DAMAGE_BOOST, duration, 0);
        MobEffectInstance damageResistanceEffect = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, 0);
        player.addEffect(speedEffect);
        player.addEffect(damageBoostEffect);
        player.addEffect(damageResistanceEffect);
    }


}
