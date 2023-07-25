package net.kardiinal.saocrystals;

import com.mojang.logging.LogUtils;
import net.kardiinal.saocrystals.item.ModCreativeModeTabs;
import net.kardiinal.saocrystals.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

//a

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SaoCrystals.MOD_ID)
public class SaoCrystals
{

    public static final String MOD_ID = "saocrystals";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public SaoCrystals() {
        
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    private void  addCreative(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.TELEPORT_CRYSTAL.get());
            event.accept(ModItems.BOOST_CRYSTAL.get());
            event.accept(ModItems.HEALING_CRYSTAL.get());
            event.accept(ModItems.ANTIDOTE_CRYSTAL.get());
        }

        if(event.getTab() == ModCreativeModeTabs.SAO_CRYSTALS){
            event.accept(ModItems.TELEPORT_CRYSTAL.get());
            event.accept(ModItems.BOOST_CRYSTAL.get());
            event.accept(ModItems.HEALING_CRYSTAL.get());
            event.accept(ModItems.ANTIDOTE_CRYSTAL.get());
        }
    }



    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
