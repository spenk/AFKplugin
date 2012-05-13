import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

public class AFKpluginFiles {
	static Logger log = Logger.getLogger("Minecraft");
    String file = "plugins/config/AFKproperties.properties";
    
    public void WriteFile(){
    	File f = new File("plugins/config");
    	f.mkdir();
    	
        BufferedWriter writer;
        File p = new File(file);
        try {
        	Writer w = new FileWriter(p, true);
                 writer = new BufferedWriter(w);
                 
                        writer.write("#####Afk-Delay-Timer#####");writer.newLine();
                        writer.write("#Time in seconds between parsing command and being real afk");writer.newLine();
                        writer.write("#Recommend to be 1 if freeze is enabled!");writer.newLine();
                        writer.write("Afk-Delay-Timer=10");writer.newLine();
                        writer.newLine();
                        writer.write("#####Freeze-Player#####");writer.newLine();
                        writer.write("#Freeze a Player when he is afk");writer.newLine();
                        writer.write("Freeze-Player=false");writer.newLine();
                        writer.newLine();
                        writer.write("#####Lock-FoodLevel#####");writer.newLine();
                        writer.write("#Lock foodlevel when a player is afk");writer.newLine();
                        writer.write("Lock-FoodLevel=false");writer.newLine();
                        writer.newLine();
                        writer.write("#####Afk-Kick#####");writer.newLine();
                        writer.write("#kick a player when he is afk for too long");writer.newLine();
                        writer.write("Afk-Kick=false");writer.newLine();
                        writer.newLine();
                        writer.write("#####Afk-Kick-Delay#####");writer.newLine();
                        writer.write("#limit of time the player may be afk (in seconds)");writer.newLine();
                        writer.write("Afk-Kick-Delay=1000");writer.newLine();
                        writer.newLine();
                        writer.write("#####Teleport-Protection#####");writer.newLine();
                        writer.write("#protect a player from being teleported while he is afk");writer.newLine();
                        writer.write("Teleport-Protection=true");writer.newLine();
                        writer.newLine();
                        writer.write("#####AFK-Messaging#####");writer.newLine();
                        writer.write("#Messages wich will be shown by afk and return");writer.newLine();
                        writer.write("#insert &colorcode for player example : afk=&3 player came back");writer.newLine();
                        writer.write("#insert /p for player example : afk=&3/p came back");writer.newLine();
                        writer.write("#insert /c for player example : afk=&3/p came back : /c (only possible with with-comment options)");writer.newLine();
                        writer.write("Afk-Message=&3/p§5 Went AFK.");writer.newLine();
                        writer.write("Afk-Message-WithComment=&3/p§5 Went AFK : /c");writer.newLine();
                        writer.write("Back-Message=&3/p§5 has returned.");writer.newLine();
                        writer.newLine();
                        writer.write("#####Trigger-back#####");writer.newLine();
                        writer.write("#this will make the player 'return' from his afk status");writer.newLine();
                        writer.write("onChatUse=true");writer.newLine();
                        writer.write("onArmSwing=true");writer.newLine();
                        writer.write("#Not recomended to use with freeze!");writer.newLine();
                        writer.write("onPlayerMove=true");writer.newLine();
                        writer.newLine();
                        writer.write("#####List-of-damage-protections#####");writer.newLine();
                        writer.write("#if an propertie here is true the damage will be prevented while a player is afk");writer.newLine();
                        writer.write("Prevent-PVP=true");writer.newLine();
                        writer.write("Prevent-mobattack=true");writer.newLine();
                        writer.write("Prevent-Cactus=true");writer.newLine();
                        writer.write("Prevent-Creeper=true");writer.newLine();
                        writer.write("Prevent-Explosion=true");writer.newLine();
                        writer.write("Prevent-Fall=true");writer.newLine();
                        writer.write("Prevent-Fire=true");writer.newLine();
                        writer.write("Prevent-FireTick=true");writer.newLine();
                        writer.write("Prevent-Lava=true");writer.newLine();
                        writer.write("Prevent-Potion=true");writer.newLine();
                        writer.write("Prevent-Water=true");writer.newLine();
                        writer.write("Prevent-Suffocation=true");writer.newLine();
                        writer.write("Prevent-Starvation=true");writer.newLine();
                        writer.write("Prevent-Lightning=true");writer.newLine();
                        writer.newLine();
                writer.close();//TODO
        } catch (IOException e) {
                log.info("[AFKplugin] could not write PropertiesFile!");
                e.printStackTrace();
        }
    }
}
