package net.ultibyte.AutoMobNamer;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

	private AutoMobNamer plugin; // pointer to the main class.
	Player p;

	public CommandHandler(AutoMobNamer plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender commandsender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("namer")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					commandsender.sendMessage("*****************" + ChatColor.DARK_RED + "Auto" + ChatColor.BLUE + "Mob" + ChatColor.YELLOW + "Namer " + ChatColor.RESET + "*****************");
					commandsender.sendMessage(ChatColor.AQUA + "The Commands are:");
					commandsender.sendMessage(ChatColor.GREEN + "/namer add [MobType] [Name (Use _ for spaces!)]");
					commandsender.sendMessage(ChatColor.GREEN + "/namer remove [MobType] [Name (Use _ for spaces!)]");
					commandsender.sendMessage(ChatColor.GREEN + "/namer ColorOff  -  Turns colors off for newly spawned mobs");
					commandsender.sendMessage(ChatColor.GREEN + "/namer ColorOn  -  Turns color on for newly spawned mobs");
					commandsender.sendMessage(ChatColor.GREEN + "/namer clear [MobType]  -  Removes all names for this Mob Type (Leaving just the mob type as its name which you can also remove if you wish.)");
					commandsender.sendMessage(ChatColor.GREEN + "/namer setvisibility [visible/invisible] - Causes mob names to only be visible when looked at at close proximity");
					commandsender.sendMessage("*****************" + ChatColor.YELLOW + "Thats it!" + ChatColor.WHITE + "*****************");
					return true;
				}
				if (args[0].equalsIgnoreCase("add")) {
					commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer add [MobType] [Name]");
				}
				if (args[0].equalsIgnoreCase("remove")) {
					commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer remove [MobType] [Name]");
				}
				if (args[0].equalsIgnoreCase("ColorOff")) {
					VariableStuff.NoColor = true;
					commandsender.sendMessage(ChatColor.GREEN + "Mob name colors have been turned off!");
				}
				if (args[0].equalsIgnoreCase("ColorOn")) {
					VariableStuff.NoColor = false;
					commandsender.sendMessage(ChatColor.GREEN + "Mob name colors are now on!");
				}
				if (args[0].equalsIgnoreCase("clear")) {
					commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer clear [MobType]");
				}

			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("add")) {
					commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer add [MobType] [Name]");
					return true;
				}
				if (args[0].equalsIgnoreCase("setvisibility")) {
					if(args[1].equalsIgnoreCase("visible") || args[1].equalsIgnoreCase("invisible")){
						if(args[1].equalsIgnoreCase("visible")){
							setVisibilityAll(true);
						}else{
							setVisibilityAll(false);
						}
						commandsender.sendMessage(ChatColor.GREEN + "Done!");
					}else{
						commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer setvisibility [visible/invisible]");
					}
					return true;
				}
				if (args[0].equalsIgnoreCase("remove")) {
					commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer remove [MobType] [Name]");
					return true;
				}
				if (args[0].equalsIgnoreCase("list")) {
					if (args[1].equalsIgnoreCase("Bat")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Bat Names ********************");
						for (String SomeName : plugin.BatNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if (args[1].equalsIgnoreCase("Chicken")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Chicken Names ********************");
						for (String SomeName : plugin.ChickenNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if (args[1].equalsIgnoreCase("Cow")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Cow Names ********************");
						for (String SomeName : plugin.CowNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("IronGolem")) || (args[1].equalsIgnoreCase("Iron_Golem")) || (args[1].equalsIgnoreCase("Villager_Golem")) || (args[1].equalsIgnoreCase("VillagerGolem"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Iron Golem Names ********************");
						for (String SomeName : plugin.IronGolemNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Mooshroom")) || (args[1].equalsIgnoreCase("MushroomCow")) || (args[1].equalsIgnoreCase("Mushroom_Cow"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Mooshroom Names ********************");
						for (String SomeName : plugin.MooshroomNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Ocelot")) || (args[1].equalsIgnoreCase("Cat"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Ocelot Names ********************");
						for (String SomeName : plugin.OcelotNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Pig"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Pig Names ********************");
						for (String SomeName : plugin.PigNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Sheep"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Sheep Names ********************");
						for (String SomeName : plugin.SheepNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Squid"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Squid Names ********************");
						for (String SomeName : plugin.SquidNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Wolf")) || (args[1].equalsIgnoreCase("Dog"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Wolf Names ********************");
						for (String SomeName : plugin.WolfNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Blaze"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Blaze Names ********************");
						for (String SomeName : plugin.BlazeNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("CaveSpider")) || (args[1].equalsIgnoreCase("Cave_Spider"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Cave Spider Names ********************");
						for (String SomeName : plugin.CaveSpiderNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("Creeper"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Creeper Names ********************");
						for (String SomeName : plugin.CreeperNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
					if ((args[1].equalsIgnoreCase("EnderDragon")) || (args[1].equalsIgnoreCase("Ender_Dragon")) || (args[1].equalsIgnoreCase("Dragon"))) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** EnderDragon Names ********************");
						for (String SomeName : plugin.EnderDragonNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Enderman")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Enderman Names ********************");
						for (String SomeName : plugin.EndermanNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Ghast")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Ghast Names ********************");
						for (String SomeName : plugin.GhastNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("MagmaCube") || args[1].equalsIgnoreCase("LavaCube") || args[1].equalsIgnoreCase("LavaSlime") || args[1].equalsIgnoreCase("MagmaSlime")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Magma Cube Names ********************");
						for (String SomeName : plugin.MagmaCubeNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Silverfish")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Silverfish Names ********************");
						for (String SomeName : plugin.SilverfishNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Skeleton")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Skeleton Names ********************");
						for (String SomeName : plugin.SkeletonNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Slime")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Slime Names ********************");
						for (String SomeName : plugin.SlimeNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("SnowGolem") || args[1].equalsIgnoreCase("SnowMan")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Snow Golem Names ********************");
						for (String SomeName : plugin.SnowGolemNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Spider")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Spider Names ********************");
						for (String SomeName : plugin.SpiderNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Witch")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Witch Names ********************");
						for (String SomeName : plugin.WitchNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Wither")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Wither Names ********************");
						for (String SomeName : plugin.WitherNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Zombie")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Zombie Names ********************");
						for (String SomeName : plugin.ZombieNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("ZombiePigman") || args[1].equalsIgnoreCase("Pigman")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Zombie Pigman Names ********************");
						for (String SomeName : plugin.ZombiePigmanNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}

					if (args[1].equalsIgnoreCase("Villager")) {
						commandsender.sendMessage(ChatColor.BLUE + "******************** Villager Names ********************");
						for (String SomeName : plugin.VillagerNames) {
							commandsender.sendMessage(ChatColor.AQUA + SomeName);
						}
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("clear")) {
					if (args[1].equalsIgnoreCase("Bat")) {
						plugin.BatNames.clear();
						plugin.BatNames.add("Bat");
						commandsender.sendMessage(ChatColor.GREEN + "Bat names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("Chicken")) {
						plugin.ChickenNames.clear();
						plugin.ChickenNames.add("Chicken");
						commandsender.sendMessage(ChatColor.GREEN + "Chicken names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("Cow")) {
						plugin.CowNames.clear();
						plugin.CowNames.add("Cow");
						commandsender.sendMessage(ChatColor.GREEN + "Cow names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("IronGolem")) || (args[1].equalsIgnoreCase("Iron_Golem")) || (args[1].equalsIgnoreCase("Villager_Golem")) || (args[1].equalsIgnoreCase("VillagerGolem"))) {
						plugin.IronGolemNames.clear();
						plugin.IronGolemNames.add("Iron Golem");
						commandsender.sendMessage(ChatColor.GREEN + "Iron Golem names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Mooshroom")) || (args[1].equalsIgnoreCase("MushroomCow")) || (args[1].equalsIgnoreCase("Mushroom_Cow"))) {
						plugin.MooshroomNames.clear();
						plugin.MooshroomNames.add("Mooshroom");
						commandsender.sendMessage(ChatColor.GREEN + "Mooshroom names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Ocelot")) || (args[1].equalsIgnoreCase("Cat"))) {
						plugin.OcelotNames.clear();
						plugin.OcelotNames.add("Ocelot");
						commandsender.sendMessage(ChatColor.GREEN + "Mooshroom names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Pig"))) {
						plugin.PigNames.clear();
						plugin.PigNames.add("Pig");
						commandsender.sendMessage(ChatColor.GREEN + "Pig names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Sheep"))) {
						plugin.SheepNames.clear();
						plugin.SheepNames.add("Sheep");
						commandsender.sendMessage(ChatColor.GREEN + "Sheep names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Squid"))) {
						plugin.SquidNames.clear();
						plugin.SquidNames.add("Squid");
						commandsender.sendMessage(ChatColor.GREEN + "Squid names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Wolf")) || (args[1].equalsIgnoreCase("Dog"))) {
						plugin.WolfNames.clear();
						plugin.WolfNames.add("Wolf");
						commandsender.sendMessage(ChatColor.GREEN + "Wolf names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Blaze"))) {
						plugin.BlazeNames.clear();
						plugin.BlazeNames.add("Blaze");
						commandsender.sendMessage(ChatColor.GREEN + "Blaze names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("CaveSpider")) || (args[1].equalsIgnoreCase("Cave_Spider"))) {
						plugin.CaveSpiderNames.clear();
						plugin.CaveSpiderNames.add("Cave Spider");
						commandsender.sendMessage(ChatColor.GREEN + "Cave Spider names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Creeper"))) {
						plugin.CreeperNames.clear();
						plugin.CreeperNames.add("Creeper");
						commandsender.sendMessage(ChatColor.GREEN + "Creeper names have been cleared!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("EnderDragon")) || (args[1].equalsIgnoreCase("Ender_Dragon")) || (args[1].equalsIgnoreCase("Dragon"))) {
						plugin.EnderDragonNames.clear();
						plugin.EnderDragonNames.add("EnderDragon");
						commandsender.sendMessage(ChatColor.GREEN + "EnderDragon names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Enderman")) {
						plugin.EndermanNames.clear();
						plugin.EndermanNames.add("Enderman");
						commandsender.sendMessage(ChatColor.GREEN + "Enderman names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Ghast")) {
						plugin.GhastNames.clear();
						plugin.GhastNames.add("Ghast");
						commandsender.sendMessage(ChatColor.GREEN + "Ghast names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("MagmaCube") || args[1].equalsIgnoreCase("LavaCube") || args[1].equalsIgnoreCase("LavaSlime") || args[1].equalsIgnoreCase("MagmaSlime")) {
						plugin.MagmaCubeNames.clear();
						plugin.MagmaCubeNames.add("MagmaCube");
						commandsender.sendMessage(ChatColor.GREEN + "MagmaCube names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Silverfish")) {
						plugin.SilverfishNames.clear();
						plugin.SilverfishNames.add("Silverfish");
						commandsender.sendMessage(ChatColor.GREEN + "Silverfish names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Skeleton")) {
						plugin.SkeletonNames.clear();
						plugin.SkeletonNames.add("Skeleton");
						commandsender.sendMessage(ChatColor.GREEN + "Skeleton names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Slime")) {
						plugin.SlimeNames.clear();
						plugin.SlimeNames.add("Slime");
						commandsender.sendMessage(ChatColor.GREEN + "Slime names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("SnowGolem") || args[1].equalsIgnoreCase("SnowMan")) {
						plugin.SnowGolemNames.clear();
						plugin.SnowGolemNames.add("Slime");
						commandsender.sendMessage(ChatColor.GREEN + "SnowGolem names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Spider")) {
						plugin.SpiderNames.clear();
						plugin.SpiderNames.add("Spider");
						commandsender.sendMessage(ChatColor.GREEN + "Spider names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Witch")) {
						plugin.WitchNames.clear();
						plugin.WitchNames.add("Witch");
						commandsender.sendMessage(ChatColor.GREEN + "Witch names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Wither")) {
						plugin.WitherNames.clear();
						plugin.WitherNames.add("Wither");
						commandsender.sendMessage(ChatColor.GREEN + "Wither names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Zombie")) {
						plugin.ZombieNames.clear();
						plugin.ZombieNames.add("Zombie");
						commandsender.sendMessage(ChatColor.GREEN + "Zombie names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("ZombiePigman") || args[1].equalsIgnoreCase("Pigman")) {
						plugin.ZombiePigmanNames.clear();
						plugin.ZombiePigmanNames.add("ZombiePigman");
						commandsender.sendMessage(ChatColor.GREEN + "ZombiePigman names have been cleared!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Villager")) {
						plugin.VillagerNames.clear();
						plugin.VillagerNames.add("Villager");
						commandsender.sendMessage(ChatColor.GREEN + "Villager names have been cleared!");
						plugin.saveConfig();
						return true;
					}
				}
			}
			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("add")) {
					if (args[1].equalsIgnoreCase("Bat")) {
						plugin.BatNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Bat Names!");
						plugin.saveConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("Chicken")) {
						plugin.ChickenNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Chicken Names!");
						plugin.saveConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("Cow")) {
						plugin.CowNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Cow Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("IronGolem")) || (args[1].equalsIgnoreCase("Iron_Golem")) || (args[1].equalsIgnoreCase("Villager_Golem")) || (args[1].equalsIgnoreCase("VillagerGolem"))) {
						plugin.IronGolemNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Iron Golem Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Mooshroom")) || (args[1].equalsIgnoreCase("MushroomCow")) || (args[1].equalsIgnoreCase("Mushroom_Cow"))) {
						plugin.MooshroomNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Mooshroom Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Ocelot")) || (args[1].equalsIgnoreCase("Cat"))) {
						plugin.OcelotNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Ocelot Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Pig"))) {
						plugin.PigNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Pig Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Sheep"))) {
						plugin.SheepNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Sheep Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Squid"))) {
						plugin.SquidNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Squid Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Wolf")) || (args[1].equalsIgnoreCase("Dog"))) {
						plugin.WolfNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Wolf Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Blaze"))) {
						plugin.BlazeNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Blaze Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("CaveSpider")) || (args[1].equalsIgnoreCase("Cave_Spider"))) {
						plugin.CaveSpiderNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Cave Spider Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("Creeper"))) {
						plugin.CreeperNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Creeper Names!");
						plugin.saveConfig();
						return true;
					}
					if ((args[1].equalsIgnoreCase("EnderDragon")) || (args[1].equalsIgnoreCase("Ender_Dragon")) || (args[1].equalsIgnoreCase("Dragon"))) {
						plugin.EnderDragonNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Ender Dragon Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Enderman")) {
						plugin.EndermanNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Enderman Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Ghast")) {
						plugin.GhastNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Ghast Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("MagmaCube") || args[1].equalsIgnoreCase("LavaCube") || args[1].equalsIgnoreCase("LavaSlime") || args[1].equalsIgnoreCase("MagmaSlime")) {
						plugin.MagmaCubeNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Magma Cube Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Silverfish")) {
						plugin.SilverfishNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Silverfish Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Skeleton")) {
						plugin.SkeletonNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Skeleton Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Slime")) {
						plugin.SlimeNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Slime Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("SnowGolem") || args[1].equalsIgnoreCase("SnowMan")) {
						plugin.SnowGolemNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Snow Golem Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Spider")) {
						plugin.SpiderNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Spider Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Witch")) {
						plugin.WitchNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Witch Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Wither")) {
						plugin.WitherNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Wither Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Zombie")) {
						plugin.ZombieNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Zombie Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("ZombiePigman") || args[1].equalsIgnoreCase("Pigman")) {
						plugin.ZombiePigmanNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Zombie Pigman Names!");
						plugin.saveConfig();
						return true;
					}

					if (args[1].equalsIgnoreCase("Villager")) {
						plugin.VillagerNames.add(args[2]);
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been added to Villager Names!");
						plugin.saveConfig();
						return true;
					}

				}

				if (args[0].equalsIgnoreCase("remove")) {
					int ItWasThere = 0;
					if (args[1].equalsIgnoreCase("Bat")) {
						for (String name : plugin.BatNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.BatNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Bat Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Bat Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("Chicken")) {
						for (String name : plugin.ChickenNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.ChickenNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Chicken Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Chicken Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if (args[1].equalsIgnoreCase("Cow")) {
						for (String name : plugin.CowNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.CowNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Cow Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Cow Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("IronGolem")) || (args[1].equalsIgnoreCase("Iron_Golem")) || (args[1].equalsIgnoreCase("Villager_Golem")) || (args[1].equalsIgnoreCase("VillagerGolem"))) {
						for (String name : plugin.IronGolemNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.IronGolemNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Iron Golem Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Iron Golem Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Mooshroom")) || (args[1].equalsIgnoreCase("MushroomCow")) || (args[1].equalsIgnoreCase("Mushroom_Cow"))) {
						for (String name : plugin.MooshroomNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.MooshroomNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Mooshroom Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Mooshroom Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Ocelot")) || (args[1].equalsIgnoreCase("Cat"))) {
						for (String name : plugin.OcelotNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.OcelotNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Ocelot Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Ocelot Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Pig"))) {
						for (String name : plugin.PigNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.PigNames.remove(args[2]);
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Sheep"))) {
						for (String name : plugin.SheepNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SheepNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Sheep Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Squid"))) {
						for (String name : plugin.SquidNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SquidNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Squid Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Wolf")) || (args[1].equalsIgnoreCase("Dog"))) {
						for (String name : plugin.WolfNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.WolfNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Wolf Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Blaze"))) {
						for (String name : plugin.BlazeNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.BlazeNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Blaze Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("CaveSpider")) || (args[1].equalsIgnoreCase("Cave_Spider"))) {
						for (String name : plugin.CaveSpiderNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.CaveSpiderNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Cave Spider Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("Creeper"))) {
						for (String name : plugin.CreeperNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.CreeperNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Creeper Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}
					
					
					
					if ((args[1].equalsIgnoreCase("EnderDragon")) || (args[1].equalsIgnoreCase("Ender_Dragon")) || (args[1].equalsIgnoreCase("Dragon"))) {
						for (String name : plugin.EnderDragonNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.EnderDragonNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from EnderDragon Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Enderman")) {
						for (String name : plugin.EndermanNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.EndermanNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Enderman Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Ghast")) {
						for (String name : plugin.GhastNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.GhastNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Ghast Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("MagmaCube") || args[1].equalsIgnoreCase("LavaCube") || args[1].equalsIgnoreCase("LavaSlime") || args[1].equalsIgnoreCase("MagmaSlime")) {
						for (String name : plugin.MagmaCubeNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.MagmaCubeNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Magma Cube Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Silverfish")) {
						for (String name : plugin.SilverfishNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SilverfishNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Silverfish Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Skeleton")) {
						for (String name : plugin.SkeletonNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SkeletonNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Skeleton Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Slime")) {
						for (String name : plugin.SlimeNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SlimeNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Slime Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("SnowGolem") || args[1].equalsIgnoreCase("SnowMan")) {
						for (String name : plugin.SnowGolemNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SnowGolemNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Snow Golem Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Spider")) {
						for (String name : plugin.SpiderNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.SpiderNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Spider Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Witch")) {
						for (String name : plugin.WitchNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.WitchNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Witch Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Wither")) {
						for (String name : plugin.WitherNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.WitherNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Wither Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Zombie")) {
						for (String name : plugin.ZombieNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.ZombieNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Zombie Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("ZombiePigman") || args[1].equalsIgnoreCase("Pigman")) {
						for (String name : plugin.ZombiePigmanNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.ZombiePigmanNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Zombie Pigman Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					}

					
					
					if (args[1].equalsIgnoreCase("Villager")) {
						for (String name : plugin.VillagerNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.VillagerNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Villager Names!");
								ItWasThere = 1;
							}
						}
						if (ItWasThere == 0) {
							commandsender.sendMessage(ChatColor.GREEN + "That name isn't in" + args[1] + " Names. (You may have misspelled it)");
						}
						plugin.saveConfig();
						return true;
					} else {
						commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " Is not a valid mob name :/ Try a different variant thereof.");
					}
				}
			}
			return false;
		}
		return false;
	}
	
	public void setVisibilityAll(boolean value) {
		for (World w : plugin.getServer().getWorlds()) {
			for (Entity e : w.getEntities()) {
				if (e.getType().isAlive() && !e.getType().equals(EntityType.PLAYER)) {
					((LivingEntity) e).setCustomNameVisible(value);
				}
			}
		}
	}
}
