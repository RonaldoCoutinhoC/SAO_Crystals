package net.kardiinal.saocrystals.item;

import net.kardiinal.saocrystals.SaoCrystals;
import net.kardiinal.saocrystals.item.custom.AntidoteCrystalItem;
import net.kardiinal.saocrystals.item.custom.BoostCrystalItem;
import net.kardiinal.saocrystals.item.custom.HealingCrystalItem;
import net.kardiinal.saocrystals.item.custom.TeleportCrystalItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SaoCrystals.MOD_ID);

    public static final RegistryObject<Item> HEALING_CRYSTAL = ITEMS.register("healing_crystal",
            () -> new HealingCrystalItem(new Item.Properties()));

    public static final RegistryObject<Item> TELEPORT_CRYSTAL = ITEMS.register("teleport_crystal",
            () -> new TeleportCrystalItem(new Item.Properties()));

    public static final RegistryObject<Item> BOOST_CRYSTAL = ITEMS.register("boost_crystal",
            () -> new BoostCrystalItem(new Item.Properties()));

    public static final RegistryObject<Item> ANTIDOTE_CRYSTAL = ITEMS.register("antidote_crystal",
            () -> new AntidoteCrystalItem(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
