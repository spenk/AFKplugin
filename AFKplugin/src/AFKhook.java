public class AFKhook implements PluginInterface{
		AFKpluginListener afkh;

		public AFKhook(AFKpluginListener ap){ afkh = ap; }

		public String getName(){
	    	  return "AFKhook";
		}
		public int getNumParameters() {
		      return 3;
		}
		public String checkParameters(Object[] os) {
			if ((os.length < 1) || (os.length > getNumParameters())) {
				return "Invalid amount of parameters.";
			}
			return null;
		}
		public Object run(Object[] os) {
			//TODO
			String type = (String)os[0];
			if (type.equalsIgnoreCase("GETLIST")){
				return afkh.afk;
			}
			//TODO
			if (type.equalsIgnoreCase("GETLIST_LENGTH")){
				return afkh.afk.size();
			}
			
			String name = (String)os[1];
			if(type.equalsIgnoreCase("CHECK")){
				if (afkh.afk.contains(name)){
					return true;
				}else{
					return false;
				}
			}
			   if (type.equalsIgnoreCase("SET")){
				Boolean b   = (Boolean)os[2];
				if (b){
					afkh.setafk(name);
				}else{ 
					afkh.setback(name);
				}
			}
			return null;
		}
	}