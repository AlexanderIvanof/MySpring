package com.alex.spring.beans;

import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class OneManBand implements Performer {

	private String name;
	private Properties songs;
	private List<Instrument> list;
	public OneManBand() {
	}

	@Override
	public void perform() throws Exception {
		System.out.println(name + " knows songs: ");
		Set<Entry<Object, Object>> set = songs.entrySet();
		for (Entry<Object, Object> entry : set) {
			System.out.println(entry.getKey() + " song is --> " + entry.getValue());
		}
		for (Instrument instr : list) {
			if(list == null || list.isEmpty()){
				System.out.println("Empty or null");
				break;
			}
			System.out.println("Play ");
			instr.play();
		}
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the songs
	 */
	public Properties getSongs() {
		return songs;
	}

	/**
	 * @param songs the songs to set
	 */
	public void setSongs(Properties songs) {
		this.songs = songs;
	}

	/**
	 * @return the list
	 */
	public List<Instrument> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Instrument> list) {
		this.list = list;
	}

}
