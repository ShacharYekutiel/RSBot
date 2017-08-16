package RS3Fisher.Actions;

import RS3Fisher.Task;
import RS3Fisher.Utils.Variables;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.LocalPath;
import org.powerbot.script.rt6.Npc;
import z.Con;

import java.util.concurrent.Callable;


public class Fish extends Task {

    int spot = 6267;

    public Fish(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activated() {
        return ctx.players.local().animation() == -1 && ctx.backpack.select().count() < 28;
    }

    @Override
    public void execute() {
        Npc fish = ctx.npcs.nearest().id(spot).poll();
        if (fish.valid()) {
            if (fish.inViewport()) {
                if (fish.interact(Interact())) {
                    int counter = 0;
                    do {
                        Condition.wait(new Callable<Boolean>() {
                            @Override
                            public Boolean call() throws Exception {
                                return ctx.backpack.select().count() == 28;
                            }
                        });
                        counter++;

                    }
                    while (ctx.players.local().animation() != -1 && counter <= 5000);
                }
            }
            else {
                ctx.camera.turnTo(fish);
                LocalPath path = ctx.movement.findPath(fish.tile());
                System.out.println(path);
                path.traverse();
            }
        }

    }

    public String Interact() {
        String answer = "";
        switch (spot) {
            case 6267:
                answer = "Cage";
                break;
        }

        if (answer != null)
            return answer;
        System.out.println(answer);
        return "There is no answer";
    }
}
