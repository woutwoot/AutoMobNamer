package net.ultibyte.AutoMobNamer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
					commandsender.sendMessage(ChatColor.GREEN + "/namer add [MobType] [Name (Use underscores for spaces!)]");
					commandsender.sendMessage(ChatColor.GREEN + "/namer remove [MobType] [Name (Use underscores for spaces!)]");
					commandsender.sendMessage(ChatColor.GREEN + "/namer ColorOff  -  Turns colors off for newly spawned mobs");
					commandsender.sendMessage(ChatColor.GREEN + "/namer ColorOn  -  Turns color on for newly spawned mobs");
					commandsender.sendMessage(ChatColor.GREEN + "/namer clear [MobType]  -  Removes all names for this Mob Type (Leaving just the mob type as its name which you can remove later)");
					commandsender.sendMessage("***************** That's it! *****************");
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
				}
				if (args[0].equalsIgnoreCase("remove")) {
					commandsender.sendMessage(ChatColor.GREEN + "Go on... it's /namer remove [MobType] [Name]");
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
					if (args[1].equalsIgnoreCase("EnderDragon")) {
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
					if (args[1].equalsIgnoreCase("EnderDragon")) {
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
					if (args[1].equalsIgnoreCase("Bat")) {
						for (String name : plugin.BatNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.BatNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Bat Names!");
							} else {
								commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Bat Names. (You may have misspelled it)");
							}
						}
						plugin.saveConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("Chicken")) {
						for (String name : plugin.ChickenNames) {
							if (name.equalsIgnoreCase(args[2])) {
								plugin.ChickenNames.remove(args[2]);
								commandsender.sendMessage(ChatColor.AQUA + "'" + args[2] + "'" + ChatColor.GREEN + " has been removed from Chicken Names!");
							} else {
								commandsender.sendMessage(ChatColor.GREEN + "That name isn't in Chicken Names. (You may have misspelled it)");
							}
						}
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
					if (args[1].equalsIgnoreCase("EnderDragon")) {
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
			}
			return false;
		}
		return false;
	}
}
