package com.noisyle.crowbar.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.noisyle.crowbar.core.util.JSONUtils;

public class AdminConstant {
	public static final String SESSION_KEY_USER_CONTEXT = "userContext";
	public static final String SESSION_KEY_CONTEXT_ROOT = "ctx";
	
	public static enum Role {
		SUPERADMIN("超级管理员"),
		ADMIN("管理员"),
		USER("用户");
		
		private String text;
		
		private Role(String text){
			this.text = text;
		}
		
		public String getText(){
			return this.text;
		}
		
		public static Role get(String str){
			Role role = null;
			if(str != null){
				role = Role.valueOf(str);
			}
			return role;
		}
		
		public static String getJSONString(int extra){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(extra==1){
				map = new HashMap<>();
				map.put("id", "");
				map.put("text", "");
				list.add(map);
			}else if(extra==2){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}
			for(Role role:Role.values()){
				if(Role.SUPERADMIN.equals(role)) continue;
				map = new HashMap<>();
				map.put("id", role.toString());
				map.put("text", role.text);
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
	
	public static enum Status {
		INVALID(0, "删除"),
		SAVE(1, "保存");
		
		private int id;
		private String text;
		
		private Status(int id, String text){
			this.id = id;
			this.text = text;
		}
		
		public int getId(){
			return this.id;
		}
		
		public String getText(){
			return this.text;
		}
		
		public static Status valueOf(int id){
			for(Status status : Status.values()){
				if(status.id == id) return status;
			}
			return null;
		}
		
		public static String getJSONString(boolean addBlank, boolean addAll){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(addBlank){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}else if(addAll){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "全部");
				list.add(map);
			}
			for(Status status:Status.values()){
				map = new HashMap<>();
				map.put("id", status.id);
				map.put("text", status.text);
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
	
	public static enum YesOrNo {
		YES(1, "是"),
		NO(2, "否");
		
		private int id;
		private String text;
		
		private YesOrNo(int id, String text){
			this.id = id;
			this.text = text;
		}
		
		public int getId(){
			return this.id;
		}
		
		public String getText(){
			return this.text;
		}
		
		public static YesOrNo valueOf(int id){
			for(YesOrNo item : YesOrNo.values()){
				if(item.id == id) return item;
			}
			return null;
		}
		
		public static String getJSONString(boolean addBlank, boolean addAll){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(addBlank){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}else if(addAll){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "全部");
				list.add(map);
			}
			for(YesOrNo item : YesOrNo.values()){
				map = new HashMap<>();
				map.put("id", item.id);
				map.put("text", item.text);
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
	
	public static enum Sexual {
		MALE(1, "男"),
		FEMALE(2, "女");
		
		private int id;
		private String text;
		
		private Sexual(int id, String text){
			this.id = id;
			this.text = text;
		}
		
		public int getId(){
			return this.id;
		}
		
		public String getText(){
			return this.text;
		}
		
		public static Sexual valueOf(int id){
			for(Sexual sexual : Sexual.values()){
				if(sexual.id == id) return sexual;
			}
			return null;
		}
		
		public static String getJSONString(boolean addBlank, boolean addAll){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(addBlank){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}else if(addAll){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "全部");
				list.add(map);
			}
			for(Sexual sexual:Sexual.values()){
				map = new HashMap<>();
				map.put("id", sexual.id);
				map.put("text", sexual.text);
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
	
	public static enum Rating {
		A(1),
		B(2),
		C(3),
		D(4),
		E(5);
		
		private int id;
		
		private Rating(int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
		public String getText(){
			return this.toString();
		}
		
		public static Rating valueOf(int id){
			for(Rating rating : Rating.values()){
				if(rating.id == id) return rating;
			}
			return null;
		}
		
		public static String getJSONString(boolean addBlank, boolean addAll){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(addBlank){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}else if(addAll){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "全部");
				list.add(map);
			}
			for(Rating rating : Rating.values()){
				map = new HashMap<>();
				map.put("id", rating.id);
				map.put("text", rating.toString());
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
	
	public static enum TrainingCatalog {
		SAFETY(1, "安全培训"),
		EQUIPMENT(2, "设备培训"),
		PRODUCTION(3, "生产培训");
		
		private int id;
		private String text;
		
		private TrainingCatalog(int id, String text){
			this.id = id;
			this.text = text;
		}
		
		public int getId(){
			return this.id;
		}
		
		public String getText(){
			return this.text;
		}
		
		public static TrainingCatalog valueOf(int id){
			for(TrainingCatalog item : TrainingCatalog.values()){
				if(item.id == id) return item;
			}
			return null;
		}
		
		public static String getJSONString(boolean addBlank, boolean addAll){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(addBlank){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}else if(addAll){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "全部");
				list.add(map);
			}
			for(TrainingCatalog item : TrainingCatalog.values()){
				map = new HashMap<>();
				map.put("id", item.id);
				map.put("text", item.text);
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
	
	public static enum TrainingMode {
		INTERNAL(1, "内训"),
		EXTERNAL(2, "外训");
		
		private int id;
		private String text;
		
		private TrainingMode(int id, String text){
			this.id = id;
			this.text = text;
		}
		
		public int getId(){
			return this.id;
		}
		
		public String getText(){
			return this.text;
		}
		
		public static TrainingMode valueOf(int id){
			for(TrainingMode item : TrainingMode.values()){
				if(item.id == id) return item;
			}
			return null;
		}
		
		public static String getJSONString(boolean addBlank, boolean addAll){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map;
			if(addBlank){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "");
				list.add(map);
			}else if(addAll){
				map = new HashMap<>();
				map.put("id", "-1");
				map.put("text", "全部");
				list.add(map);
			}
			for(TrainingMode item : TrainingMode.values()){
				map = new HashMap<>();
				map.put("id", item.id);
				map.put("text", item.text);
				list.add(map);
			}
			return JSONUtils.toJSON(list);
		}
	}
}
