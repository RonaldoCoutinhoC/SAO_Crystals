package net.kardiinal.saocrystals.item;

import net.kardiinal.saocrystals.SaoCrystals;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaoCrystals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab SAO_CRYSTALS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        SAO_CRYSTALS = event.registerCreativeModeTab(new ResourceLocation(SaoCrystals.MOD_ID, "sao_crystals"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TELEPORT_CRYSTAL.get()))
                        .title(Component.translatable("creativemodetab.sao_crystals")));
    }

}
