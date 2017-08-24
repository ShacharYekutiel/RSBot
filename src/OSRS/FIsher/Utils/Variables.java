package OSRS.FIsher.Utils;


import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Item;

public class Variables {
    //Fishing Spots
    public static final int Lumbridge_Spot = 1530;
    public static final int Draynor_Spot = 1525;
    public static final int BarbarianVillage_Spot = 1526;
    //Rods
    public static final int Small_Net_ID = 303;
    public static final int Fishing_Rod_ID = 307;
    public static final int Cage_ID = 301;
    public static final int Harpoon_ID = 311;
    public static final int Fly_Fishing_Rod = 309;

    //Baits
    public static final int Fishing_Bait_ID = 313;
    public static final int Feather_ID = 314;

    //Fishes
    public static final int Shrimp_ID = 317;
    public static final int Sardine_ID = 327;
    public static final int Anchovie_ID = 321;
    public static final int Herring_ID = 345;
    public static final int Trout_ID = 335;
    public static final int Pike_ID = 349;
    public static final int Salmon_ID = 331;




    //Main Variables
    public static int spot;
    public static int[] fishID = new int[10];
    public static int rodID;
    public static Tile pathToBank[];
    public static boolean powerFishing;
    public static Area bankArea;
    public static Area fishingArea;
    public static int pos = 0;
    public static String status = "Null";
    public static Enum status1;


    //Paths
    public static final Tile Lumbridge_Swamp_To_Castle[] = {new Tile(3242, 3152, 0), new Tile(3238, 3152, 0), new Tile(3239, 3156, 0), new Tile(3239, 3160, 0), new Tile(3239, 3164, 0), new Tile(3239, 3168, 0), new Tile(3239, 3172, 0), new Tile(3239, 3176, 0), new Tile(3239, 3180, 0), new Tile(3239, 3184, 0), new Tile(3242, 3188, 0), new Tile(3244, 3192, 0), new Tile(3241, 3196, 0), new Tile(3239, 3200, 0), new Tile(3236, 3203, 0), new Tile(3236, 3207, 0), new Tile(3234, 3211, 0), new Tile(3234, 3215, 0), new Tile(3231, 3218, 0), new Tile(3227, 3218, 0), new Tile(3223, 3218, 0), new Tile(3219, 3218, 0), new Tile(3215, 3218, 0), new Tile(3213, 3214, 0), new Tile(3210, 3211, 0), new Tile(3205, 3209, 1), new Tile(3205, 3209, 2), new Tile(3205, 3213, 2), new Tile(3206, 3217, 2), new Tile(3209, 3220, 2)};
    public static final Tile BarbarianVillage_To_EdgeBank[] = {new Tile(3103, 3425, 0), new Tile(3101, 3429, 0), new Tile(3100, 3434, 0), new Tile(3096, 3437, 0), new Tile(3094, 3441, 0), new Tile(3091, 3445, 0), new Tile(3091, 3449, 0), new Tile(3093, 3453, 0), new Tile(3092, 3457, 0), new Tile(3089, 3461, 0), new Tile(3091, 3465, 0), new Tile(3095, 3465, 0), new Tile(3098, 3468, 0), new Tile(3098, 3472, 0), new Tile(3098, 3476, 0), new Tile(3098, 3480, 0), new Tile(3095, 3483, 0), new Tile(3091, 3486, 0), new Tile(3090, 3490, 0), new Tile(3094, 3491, 0)};
    public static final Tile Draynor_To_Bank[] = {new Tile(3086, 3230, 0), new Tile(3086, 3233, 0), new Tile(3087, 3236, 0), new Tile(3087, 3239, 0), new Tile(3087, 3242, 0), new Tile(3087, 3245, 0), new Tile(3090, 3247, 0), new Tile(3092, 3244, 0)};

    //Areas
    //Spots area
    public static final Area Lumbridge_Swamp = new Area(new Tile(3245, 3156, 0), new Tile(3240, 3142, 0));
    public static final Area Draynor = new Area(new Tile(3088, 3225, 0), new Tile(3081, 3238, 0));
    public static final Area BarbarianVillage = new Area(new Tile(3100,3435, 0), new Tile(3115, 3422, 0));

    //Banks area
    public static final Area Lumbridge_Castle = new Area(new Tile(3208, 3216, 0), new Tile(3208, 3223,0));
    public static final Area Draynor_Village = new Area(new Tile(3097, 3240, 0), new Tile(3088, 3246, 0));
    public static final Area Edge_Bank = new Area(new Tile(3091, 3488, 0), new Tile(3098, 3500, 0));

    //Methods

    public static void addFish(int id) {
        fishID[pos] = id;
        pos++;
    }
    public static void setLocation(Area spot, Area bank, Tile path[]) {
        bankArea = bank;
        fishingArea = spot;
        pathToBank = path;
    }
    public static void setSpot(int s, int r) {
        spot = s;
        rodID = r;
    }
}
