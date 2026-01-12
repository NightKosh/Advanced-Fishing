# Advanced Fishing [![CurseForge](https://cf.way2muchnoise.eu/full_303541_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/advanced-fishing) [![CurseForge](https://cf.way2muchnoise.eu/versions/For%20MC_303541_all.svg)](https://www.curseforge.com/minecraft/mc-mods/advanced-fishing)

This mod adds new 43 fishes, blaze fishing rod, luck potion recipe, experience bottle recipe and overrides fishing mechanics. All new and vanilla fishes can be caught only in own types of biomes, dimensions and liquids.

![advanced_fishing](https://user-images.githubusercontent.com/4181327/46245962-92192b80-c3ff-11e8-9f61-02d8ef7eb9e7.png)

## Luck potion recipe

![luck_potion](https://user-images.githubusercontent.com/4181327/45934183-23714380-bfa3-11e8-8d02-37cb78e65472.png)


## Crafting recipes

![fish_recipes](https://user-images.githubusercontent.com/4181327/46245968-9fceb100-c3ff-11e8-956b-ad451c2c9eb8.png)


## Minecraft versions
"Master branch" contains mod sources for the latest version of the Minecraft I'm working on. Any previous versions contains in an own branches.

## Requirements
1. [NeoForge](https://neoforged.net/) (check "build.gradle" file to know required NeoForge version)
2. [Jdk 21.0.2](https://jdk.java.net/archive/) (do not forget to enable its support in your IDE)
3. [Gradle 9.2.1](https://gradle.org/releases/)


## Get started
1. Clone mod repository
2. Download NeoForge ~~and copy "gradlew.bat", "gradlew" files and "gradle" directory to mod folder(and any other files which may requires)~~
3. Download MDK from NeoForge
4. Import mod to your ide as "new Gradle project"

## Gradle commands
1. Running client
    ```
        gradlew runClient
    ```
2. Running Server
    ```
        gradlew runServer
    ```
3. Build mod as .jar file
    ```
        gradlew build
    ```

For more information, look at "minecraft NeoForge" README.txt file (it's not included to this repository) or [this link](https://docs.neoforged.net/)

## How to test:

1. To run GameTests:
    ```
        gradlew runGameTestServer
    ```
2. To run GameTests(in game command):
    ```
        /test runall
    ```
3. Nether bridge loot modification(in game command):
    ```
        /loot spawn ~ ~ ~ loot minecraft:chests/nether_bridge
    ```

## Useful commands

## Apply an enchantment on item:
1. Luminous float
    ```
        /enchant @s advanced_fishing:luminous_float 1
    ``` 
2. Infernal line
    ```
        /enchant @s advanced_fishing:infernal_line 1
    ``` 

## Apply cursed enchantment on item:
1. Curse of the abyss
    ```
        /enchant @s advanced_fishing:curse_of_the_abyss 1
    ``` 
2. Curse of false bite
    ```
        /enchant @s advanced_fishing:curse_of_false_bite 1
    ``` 
3. Curse of scorching line
    ```
        /enchant @s advanced_fishing:curse_of_scorching_line 1
    ``` 
