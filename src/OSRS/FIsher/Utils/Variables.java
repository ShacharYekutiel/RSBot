package OSRS.FIsher.Utils;


import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class Variables {
    //Fishing Spots
    public static final int Shrimp_Spot = 1530;
    //Rods
    public static final int Small_Net_ID = 303;

    //Fishes
    public static final int Shrimp_ID = 317;
    public static final int Sardine_ID = 327;
    public static final int Anchovie_ID = 321;
    public static final int Herring_ID = 345;




    //Main Variables
    public static int spot;
    public static int fishID;
    public static String method;
    public static int rodID;
    public static Tile pathToBank[];
    public static boolean powerFishing = false;
    public static Area bankArea;
    public static Area fishingArea;


    //Paths
    public static final Tile Lumbridge_Swamp_To_Castle[] = {new Tile(3242, 3152, 0), new Tile(3238, 3152, 0), new Tile(3239, 3156, 0), new Tile(3239, 3160, 0), new Tile(3239, 3164, 0), new Tile(3239, 3168, 0), new Tile(3239, 3172, 0), new Tile(3239, 3176, 0), new Tile(3239, 3180, 0), new Tile(3239, 3184, 0), new Tile(3242, 3188, 0), new Tile(3244, 3192, 0), new Tile(3241, 3196, 0), new Tile(3239, 3200, 0), new Tile(3236, 3203, 0), new Tile(3236, 3207, 0), new Tile(3234, 3211, 0), new Tile(3234, 3215, 0), new Tile(3231, 3218, 0), new Tile(3227, 3218, 0), new Tile(3223, 3218, 0), new Tile(3219, 3218, 0), new Tile(3215, 3218, 0), new Tile(3213, 3214, 0), new Tile(3210, 3211, 0), new Tile(3205, 3209, 1), new Tile(3205, 3209, 2), new Tile(3205, 3213, 2), new Tile(3206, 3217, 2), new Tile(3209, 3220, 2)};

    //Areas
    //Spots area
    public static final Area Lumbridge_Swamp = new Area(new Tile(3245, 3156, 0), new Tile(3240, 3142, 0));
    public static final Area Draynor = new Area(new Tile(3088, 3225, 0), new Tile(3081, 3238, 0));
    //Banks area
    public static final Area Lumbridge_Castle = new Area(new Tile(3208, 3216, 0), new Tile(3208, 3223,0));
    public static final Area Draynor_Village = new Area(new Tile(3097, 3240, 0), new Tile(3088, 3246, 0));
    //Methods
}
