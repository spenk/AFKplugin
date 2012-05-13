import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;


public class AFKpluginListener extends PluginListener{
	static Logger log = Logger.getLogger("Minecraft");
	int tp;
	int afkkicktime;
	String afkmsg;
	String backmsg;
	String afkmsgcomment;
	boolean playerp;
	boolean mobs;
	boolean cactus;
	boolean creeper;
	boolean explosion;
	boolean fall;
	boolean fire;
	boolean firetick;
	boolean lava;
	boolean potion;
	boolean water;
	boolean suffocation;
	boolean starvation;
	boolean lightning;
	boolean afkkick;
	boolean chat;
	boolean move;
	boolean armswing;
	boolean freeze;
	boolean teleport;
	boolean foodlevel;

	public void checkprops(){
		File f = new File ("plugins/config/AFKproperties.properties");
		if (f.exists()){
			loadProperties();
			log.info("[AFKplugin] - Properties initialized");
			return;
		}else{
			AFKpluginFiles filer = new AFKpluginFiles();
			filer.WriteFile();
			log.info("[AFKplugin] - PropertiesFile Created");
			loadProperties();
            log.info("[AFKplugin] - Properties initialized");
			return;
		}
	}
    public void loadProperties(){
    PropertiesFile f = new PropertiesFile("plugins/config/AFKProperties.properties");
    try{tp = Integer.parseInt(f.getProperty("Afk-Delay-Timer"));}catch(NumberFormatException nfe){log.info("[AFKplugin] - could not resolve Afk-Delay-Timer using default"); tp = 10;}
    try{afkkicktime = Integer.parseInt(f.getProperty("Afk-Kick-Delay"));}catch(NumberFormatException nfe){log.info("[AFKplugin] - could not resolve Afk-Kick-Delay using default"); afkkicktime = 1000;}
    freeze = Boolean.parseBoolean(f.getProperty("Freeze-Player"));
    afkkick = Boolean.parseBoolean(f.getProperty("Afk-Kick"));
    chat = Boolean.parseBoolean(f.getProperty("onChatUse"));
    armswing = Boolean.parseBoolean(f.getProperty("onArmSwing"));
    move = Boolean.parseBoolean(f.getProperty("onPlayerMove"));
    
    playerp = Boolean.parseBoolean(f.getProperty("Prevent-PVP"));
    mobs = Boolean.parseBoolean(f.getProperty("Prevent-mobattack"));
    cactus = Boolean.parseBoolean(f.getProperty("Prevent-Cactus"));
    creeper = Boolean.parseBoolean(f.getProperty("Prevent-Creeper"));
    
    explosion = Boolean.parseBoolean(f.getProperty("Prevent-Explosion"));
    fall = Boolean.parseBoolean(f.getProperty("Prevent-Fall"));
    fire = Boolean.parseBoolean(f.getProperty("Prevent-Fire"));
    firetick = Boolean.parseBoolean(f.getProperty("Prevent-FireTick"));
    
    lava = Boolean.parseBoolean(f.getProperty("Prevent-Lava"));
    potion = Boolean.parseBoolean(f.getProperty("Prevent-Potion"));
    water = Boolean.parseBoolean(f.getProperty("Prevent-Water"));
    suffocation = Boolean.parseBoolean(f.getProperty("Prevent-Suffocation"));
    starvation = Boolean.parseBoolean(f.getProperty("Prevent-Starvation"));
    lightning = Boolean.parseBoolean(f.getProperty("Prevent-Lightning"));
    teleport = Boolean.parseBoolean(f.getProperty("Teleport-Protection"));
    foodlevel = Boolean.parseBoolean(f.getString("Lock-FoodLevel"));
    
    afkmsg = f.getProperty("Afk-Message");
    backmsg = f.getProperty("Back-Message");
    afkmsgcomment = f.getProperty("Afk-Message-WithComment");
    }
    
	ArrayList<String> afk = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();
	
	public boolean onCommand(Player player,String[] split){
		if (split[0].equals("/afk")&&player.canUseCommand("/afk")){
			if (split.length < 1){
				player.notify("The correct usage is '/afk'");
				return true;
				}//TODO
			if (!temp.contains(player.getName())){
			if (!afk.contains(player.getName())){
				if (split.length == 1){
            setafk(player.getName());
            return true;
				}else{
					String comment = etc.combineSplit(1, split, " ");
					setafk2(player.getName(),comment);
					return true;
				}
			}else{
				setback(player.getName());
				return true;
			}
			
			}else{
				player.notify("Your afk request is in progress please wait");
				return true;
			}
		}
		if (split[0].equalsIgnoreCase("/afklist")&&player.canUseCommand("/afk")){
			if (split.length <1 || split.length >1){
				player.notify("The correct usage is '/afklist'");
				return true;
			}
			player.sendMessage("§3"+afk);
			return true;
		}
		return false;
		}
	
	
	public boolean onDamage(PluginLoader.DamageType type,BaseEntity attacker,BaseEntity defender,int amount){
		if (defender.isPlayer()){
			Player player = defender.getPlayer();
			if(afk.contains(player.getName())){
		if ((type == PluginLoader.DamageType.ENTITY)&&(attacker.isPlayer())) {
			if (playerp == true){
				return true;
			}
		}
		
		if ((type == PluginLoader.DamageType.ENTITY)&& (attacker.isMob())) {
			if (mobs == true){
				return true;
			}
		}
		
		if ((type == PluginLoader.DamageType.CACTUS)){
			if (cactus == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.CREEPER_EXPLOSION)){
			if (creeper == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.EXPLOSION)){
			if (explosion == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.FALL)){
			if (fall == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.FIRE)){
			if (fire == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.FIRE_TICK)){
			if (firetick == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.LAVA)){
			if (lava == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.LIGHTNING)){
			if (lightning == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.POTION)){
			if (potion == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.STARVATION)){
			if (starvation == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.SUFFOCATION)){
			if (suffocation == true){
				return true;
			}
		}
		if ((type == PluginLoader.DamageType.WATER)){
			if (water == true){
				return true;
			}
		}
			}
		}
		return false;
		}
	
    public void	onArmSwing(Player player){ 
    	if (armswing){
		if (afk.contains(player.getName())){
			setback(player.getName());
			return;
		}
		}
	}
    
    public void setafk(String s){
    	if (!afk.contains(s)&&!temp.contains(s)){
    	temp.add(s);
		onTimerEnd(s,tp*1000,afk);
		if (afkkick == true){AfkKick(s,afkkicktime*1000,afk);}
    	etc.getServer().messageAll(decodemsg(afkmsg,s,"null"));
    	return;
    	}
    	return;
    }
    
    public void setafk2(String player,String comment){
    	if (!afk.contains(player)&&!temp.contains(player)){
    	temp.add(player);
		onTimerEnd(player,tp*1000,afk);
		if (afkkick == true){AfkKick(player,afkkicktime*1000,afk);}
    	etc.getServer().messageAll(decodemsg(afkmsgcomment,player,comment));//TODO
    	return;
    	}
    	return;
    }
    
    public void setback(String s){
    	if (afk.contains(s)){
    		afk.remove(s);
    		etc.getServer().messageAll(decodemsg(backmsg,s,"null"));
    		return;
    	}
    	return;
    }
    
    public boolean onChat(Player player, String message){
    	if (chat){
    		if (afk.contains(player.getName())){
    		setback(player.getName());
    		}
    	}
		return false;
	}
    
    public void onPlayerMove(Player player,Location from,Location to){
    	if (freeze){
    		if (afk.contains(player.getName())){
    			player.teleportTo(from);
    			player.sendMessage("§cYou Are Afk!");//TODO
    		}
    	}
    	
    	if (move){
    		if (afk.contains(player.getName())){
    		setback(player.getName());
    		}
    	}
    }
    
	public void onDisconnect(Player player){
		if (afk.contains(player.getName())){
		setback(player.getName());
		}
	}
	
	public void onTimerEnd(final String s, final int time, final ArrayList<String> a){
	     new Thread() {
		     public void run() {
		          try{
		                Thread.sleep(time);
		                a.add(s);
		                temp.remove(s);
		          }catch(InterruptedException e) {log.info("[AFKplugin] - an error occured during afk timer");}
		     }
		}.start();
	}
	public void AfkKick(final String s, final int time, final ArrayList<String> a){
	     new Thread() {
		     public void run() {
		          try{
		                Thread.sleep(time);
		                if (a.contains(s)){
		                	Player p = etc.getServer().matchPlayer(s);
		                p.kick("§4You've been AFK for too long!");
		                }
		          }catch(InterruptedException e) {log.info("[AFKplugin] - an error occured during afk kick timer launch");}
		     }
		}.start();
	}
	public boolean onTeleport(Player player,Location from,Location to){
		if (afk.contains(player.getName()) && teleport){
			player.notify("You are AFK you cant releport!");
			return true;
		}
		return false;
	}
	public int onFoodLevelChange(Player player,int oldFoodLevel,int newFoodLevel){
		if (foodlevel && afk.contains(player.getName())){
		return oldFoodLevel;//TODO
		}
		return newFoodLevel;
	}
	
	public String decodemsg(String msg , String name, String comment){
		msg = msg.replace("&", "§");
		msg = msg.replace("/p", name);
		msg = msg.replace("/c", comment);
		return msg;
	}
}
