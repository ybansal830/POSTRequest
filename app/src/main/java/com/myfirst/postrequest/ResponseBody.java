package com.myfirst.postrequest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseBody implements Serializable {

	@SerializedName("id")
	private int id;

	public int getId(){
		return id;
	}
}