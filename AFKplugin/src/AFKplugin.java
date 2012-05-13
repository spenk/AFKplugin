import java.util.logging.Logger;
public class AFKplugin extends Plugin{
		  String name = "AFKplugin";
		  String version = "2.0";
		  String author = " spenk";
		  static Logger log = Logger.getLogger("Minecraft");
		  AFKpluginListener listener = new AFKpluginListener();
		  
	public void initialize(){
	log.info(this.name +" version "+ this.version + " by " +this.author+(" is initialized!"));
	etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
	etc.getLoader().addListener(PluginLoader.Hook.ARM_SWING, listener, this, PluginListener.Priority.MEDIUM);
	etc.getLoader().addListener(PluginLoader.Hook.CHAT, listener, this, PluginListener.Priority.MEDIUM);
	etc.getLoader().addListener(PluginLoader.Hook.PLAYER_MOVE, listener, this, PluginListener.Priority.MEDIUM);
	etc.getLoader().addListener(PluginLoader.Hook.DAMAGE, listener, this, PluginListener.Priority.MEDIUM);
	etc.getLoader().addListener(PluginLoader.Hook.DISCONNECT, listener, this, PluginListener.Priority.MEDIUM);
	etc.getLoader().addListener(PluginLoader.Hook.TELEPORT, listener, this, PluginListener.Priority.MEDIUM);
	listener.checkprops();
	etc.getLoader().addCustomListener(new AFKhook(listener));
	}
	public void enable(){
		etc.getInstance().addCommand("/afk", "to go afk");
		etc.getInstance().addCommand("/afklist", "to see the afk list");
		log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
	}

	public void disable(){
		listener.afk.clear();
		etc.getInstance().removeCommand("/afk");
		etc.getInstance().removeCommand("/afklist");
		log.info(this.name + " version " + this.version + " is disabled!");
	}
	}
