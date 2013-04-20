package net.ultibyte.AutoMobNamer;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import net.ultibyte.AutoMobNamer.MetricsLite;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoMobNamer extends JavaPlugin implements Listener {

	List<String> BatNames = new ArrayList<String>();
	List<String> ChickenNames = new ArrayList<String>();
	List<String> CowNames = new ArrayList<String>();
	List<String> IronGolemNames = new ArrayList<String>();
	List<String> MooshroomNames = new ArrayList<String>();
	List<String> OcelotNames = new ArrayList<String>();
	List<String> PigNames = new ArrayList<String>();
	List<String> SheepNames = new ArrayList<String>();
	List<String> SquidNames = new ArrayList<String>();
	List<String> WolfNames = new ArrayList<String>();
	List<String> BlazeNames = new ArrayList<String>();
	List<String> CaveSpiderNames = new ArrayList<String>();
	List<String> CreeperNames = new ArrayList<String>();
	List<String> EnderDragonNames = new ArrayList<String>();
	List<String> EndermanNames = new ArrayList<String>();
	List<String> GhastNames = new ArrayList<String>();
	List<String> MagmaCubeNames = new ArrayList<String>();
	List<String> SilverfishNames = new ArrayList<String>();
	List<String> SkeletonNames = new ArrayList<String>();
	List<String> SlimeNames = new ArrayList<String>();
	List<String> SnowGolemNames = new ArrayList<String>();
	List<String> SpiderNames = new ArrayList<String>();
	List<String> WitchNames = new ArrayList<String>();
	List<String> WitherNames = new ArrayList<String>();
	List<String> ZombieNames = new ArrayList<String>();
	List<String> ZombiePigmanNames = new ArrayList<String>();
	List<String> VillagerNames = new ArrayList<String>();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		loadConfig();
		try {
			MetricsLite metrics = new MetricsLite(this);
			metrics.start();
		} catch (IOException e) {
			// Failed to submit the stats :-(
		}
		
		getCommand("namer").setExecutor(new CommandHandler(this));

		Server server = this.getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage(ChatColor.DARK_RED + "Auto" + ChatColor.BLUE + "Mob" + ChatColor.YELLOW + "Namer " + ChatColor.RESET + "has been " + ChatColor.GREEN + ChatColor.BOLD + "enabled" + ChatColor.RESET + "!");
		VariableStuff.NoColor = false;
	}

	@Override
	public void onDisable() {
		Server server = this.getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage(ChatColor.DARK_RED + "Auto" + ChatColor.BLUE + "Mob" + ChatColor.YELLOW + "Namer " + ChatColor.RESET + "has been " + ChatColor.RED + ChatColor.BOLD + "disabled" + ChatColor.RESET + ".");
		saveConfig();
	}

	List<String> ListOfColorCodes = new ArrayList<String>();

	public void PutColorCodesIntoList() {
		if (ListOfColorCodes.isEmpty()) {
			ListOfColorCodes.add("§0");
			ListOfColorCodes.add("§1");
			ListOfColorCodes.add("§2");
			ListOfColorCodes.add("§3");
			ListOfColorCodes.add("§4");
			ListOfColorCodes.add("§5");
			ListOfColorCodes.add("§6");
			ListOfColorCodes.add("§7");
			ListOfColorCodes.add("§8");
			ListOfColorCodes.add("§9");
			ListOfColorCodes.add("§a");
			ListOfColorCodes.add("§b");
			ListOfColorCodes.add("§c");
			ListOfColorCodes.add("§d");
			ListOfColorCodes.add("§e");
			ListOfColorCodes.add("§f");
			ListOfColorCodes.add("§8");
		}
		if (VariableStuff.NoColor) {
			ListOfColorCodes.clear();
			ListOfColorCodes.add("§f");

		}

	}

	public String RandomColorMethod() {
		int ColorSelection = createRandom(0, ListOfColorCodes.size());
		String RandomlySelectedColor = ListOfColorCodes.get(ColorSelection);
		return RandomlySelectedColor;
	}

	public void loadConfig() {
		getConfig().options().copyDefaults(true);

		BatNames = getConfig().getStringList("BatNames");
		ChickenNames = getConfig().getStringList("ChickenNames");
		CowNames = getConfig().getStringList("CowNames");
		IronGolemNames = getConfig().getStringList("IronGolemNames");
		MooshroomNames = getConfig().getStringList("MooshroomNames");
		OcelotNames = getConfig().getStringList("OcelotNames");
		PigNames = getConfig().getStringList("PigNames");
		SheepNames = getConfig().getStringList("SheepNames");
		SquidNames = getConfig().getStringList("SquidNames");
		WolfNames = getConfig().getStringList("WolfNames");
		BlazeNames = getConfig().getStringList("BlazeNames");
		CaveSpiderNames = getConfig().getStringList("CaveSpiderNames");
		CreeperNames = getConfig().getStringList("CreeperNames");
		EnderDragonNames = getConfig().getStringList("EnderdragonNames");
		EndermanNames = getConfig().getStringList("EndermanNames");
		GhastNames = getConfig().getStringList("GhastNames");
		MagmaCubeNames = getConfig().getStringList("MagmaCubeNames");
		SilverfishNames = getConfig().getStringList("SilverfishNames");
		SlimeNames = getConfig().getStringList("SlimeNames");
		SkeletonNames = getConfig().getStringList("SkeletonNames");
		SnowGolemNames = getConfig().getStringList("SnowGolemNames");
		SpiderNames = getConfig().getStringList("SpiderNames");
		WitchNames = getConfig().getStringList("WitchNames");
		WitherNames = getConfig().getStringList("WitherNames");
		ZombieNames = getConfig().getStringList("ZombieNames");
		VillagerNames = getConfig().getStringList("VillagerNames");
		ZombiePigmanNames = getConfig().getStringList("ZombiePigmanNames");
		saveConfig();
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		PutColorCodesIntoList();
		setRandomName(event.getEntity());
	}

	public void setRandomName(LivingEntity ent){
		EntityType mob = ent.getType();
		if (mob == EntityType.BAT) {
			int index = createRandom(0, BatNames.size());
			ent.setCustomName(RandomColorMethod() + BatNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.CHICKEN) {
			int index = createRandom(0, ChickenNames.size());
			ent.setCustomName(RandomColorMethod() + ChickenNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.COW) {
			int index = createRandom(0, CowNames.size());
			ent.setCustomName(RandomColorMethod() + CowNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.IRON_GOLEM) {
			int index = createRandom(0, IronGolemNames.size());
			ent.setCustomName(RandomColorMethod() + IronGolemNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.MUSHROOM_COW) {
			int index = createRandom(0, MooshroomNames.size());
			ent.setCustomName(RandomColorMethod() + MooshroomNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.OCELOT) {
			int index = createRandom(0, OcelotNames.size());
			ent.setCustomName(RandomColorMethod() + OcelotNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.PIG) {
			int index = createRandom(0, PigNames.size());
			ent.setCustomName(RandomColorMethod() + PigNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SHEEP) {
			int index = createRandom(0, SheepNames.size());
			ent.setCustomName(RandomColorMethod() + SheepNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SQUID) {
			int index = createRandom(0, SquidNames.size());
			ent.setCustomName(RandomColorMethod() + SquidNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.WOLF) {
			int index = createRandom(0, WolfNames.size());
			ent.setCustomName(RandomColorMethod() + WolfNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.BLAZE) {
			int index = createRandom(0, BlazeNames.size());
			ent.setCustomName(RandomColorMethod() + BlazeNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.CAVE_SPIDER) {
			int index = createRandom(0, CaveSpiderNames.size());
			ent.setCustomName(RandomColorMethod() + CaveSpiderNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.CREEPER) {
			int index = createRandom(0, CreeperNames.size());
			ent.setCustomName(RandomColorMethod() + CreeperNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.ENDER_DRAGON) {
			int index = createRandom(0, EnderDragonNames.size());
			ent.setCustomName(RandomColorMethod() + EnderDragonNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.ENDERMAN) {
			int index = createRandom(0, EndermanNames.size());
			ent.setCustomName(RandomColorMethod() + EndermanNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.GHAST) {
			int index = createRandom(0, GhastNames.size());
			ent.setCustomName(RandomColorMethod() + GhastNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.MAGMA_CUBE) {
			int index = createRandom(0, MagmaCubeNames.size());
			ent.setCustomName(RandomColorMethod() + MagmaCubeNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SILVERFISH) {
			int index = createRandom(0, SilverfishNames.size());
			ent.setCustomName(RandomColorMethod() + SilverfishNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SKELETON) {
			int index = createRandom(0, SkeletonNames.size());
			ent.setCustomName(RandomColorMethod() + SkeletonNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SLIME) {
			int index = createRandom(0, SlimeNames.size());
			ent.setCustomName(RandomColorMethod() + SlimeNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SNOWMAN) {
			int index = createRandom(0, SnowGolemNames.size());
			ent.setCustomName(RandomColorMethod() + SnowGolemNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.SPIDER) {
			int index = createRandom(0, SpiderNames.size());
			ent.setCustomName(RandomColorMethod() + SpiderNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.WITCH) {
			int index = createRandom(0, WitchNames.size());
			ent.setCustomName(RandomColorMethod() + WitchNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.WITHER) {
			int index = createRandom(0, WitherNames.size());
			ent.setCustomName(RandomColorMethod() + WitherNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.ZOMBIE) {
			int index = createRandom(0, ZombieNames.size());
			ent.setCustomName(RandomColorMethod() + ZombieNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.VILLAGER) {
			int index = createRandom(0, VillagerNames.size());
			ent.setCustomName(RandomColorMethod() + VillagerNames.get(index));
			ent.setCustomNameVisible(true);
		}

		if (mob == EntityType.PIG_ZOMBIE) {
			int index = createRandom(0, ZombiePigmanNames.size());
			ent.setCustomName(RandomColorMethod() + ZombiePigmanNames.get(index));
			ent.setCustomNameVisible(true);
		}
	}
	
	public int createRandom(int min, int max) {
		max = max - 1;
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
}
