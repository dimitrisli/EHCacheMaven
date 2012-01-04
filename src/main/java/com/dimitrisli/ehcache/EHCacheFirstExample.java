package com.dimitrisli.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheFirstExample {

	private final CacheManager cacheManager;
	private final Cache cache;
	
	public EHCacheFirstExample(){
		//cacheManager = new CacheManager(getClass().getResource("/src/main/resources/ehcache.xml"));
		cacheManager = CacheManager.create();
		cache = cacheManager.getCache("sampleCacheFromEhcacheXml");
	}
	
	public Cache getCache() {
		return this.cache;
	}
	
	public void addElementToCache(Element element){
		this.cache.put(element);
	}
	
	public static void main(String[] args) {
		EHCacheFirstExample fe = new EHCacheFirstExample();
		fe.addElementToCache(new Element("myCacheEntryKey","myCacheEntryVal"));
		for(Object key : fe.getCache().getKeys()){
			System.out.println(key + ":"+ (String) fe.getCache().get(key).getObjectValue());
		}
	}
}
