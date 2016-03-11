package com.mtech.utils;

import java.util.ArrayList;
import java.util.List;

import com.mtech.uam.basedata.vo.Dict;
import com.mtech.uam.enumdata.AvailableStatus;
import com.mtech.uam.enumdata.SchedulerJobRunResult;
import com.mtech.uam.enumdata.SchedulerJobRunStatus;

public class DictUtil {

	private  static List<Dict> allDict=new ArrayList<Dict>();
	
	static{
		
		allDict.add(new Dict(AvailableStatus.Valid.getCode(), AvailableStatus.Valid.getValue(), AvailableStatus.DICT_TYPE.getCode()));
		allDict.add(new Dict(AvailableStatus.Invalid.getCode(), AvailableStatus.Invalid.getValue(), AvailableStatus.DICT_TYPE.getCode()));
		
		allDict.add(new Dict(SchedulerJobRunResult.FAIL.getCode(), SchedulerJobRunResult.FAIL.getValue(), SchedulerJobRunResult.DICT_TYPE.getCode()));
		allDict.add(new Dict(SchedulerJobRunResult.SUCCESS.getCode(), SchedulerJobRunResult.SUCCESS.getValue(), SchedulerJobRunResult.DICT_TYPE.getCode()));
		
		allDict.add(new Dict(SchedulerJobRunStatus.RUNNING.getCode(), SchedulerJobRunStatus.RUNNING.getValue(), SchedulerJobRunStatus.DICT_TYPE.getCode()));
		allDict.add(new Dict(SchedulerJobRunStatus.FINISHED.getCode(), SchedulerJobRunStatus.FINISHED.getValue(), SchedulerJobRunStatus.DICT_TYPE.getCode()));
	}
	
	public static Dict findDictByType(String dictType){
		Dict dict = new Dict();
		List<Dict> children=new ArrayList<Dict>();
		for(Dict d:allDict){
		     if(d.getType().equalsIgnoreCase(dictType)){
		    	 
		    	 children.add(d);
		     }
		}
		dict.setChildren(children);	
	    return dict;
	}
	
	public static Dict findDictByTypeAndCode(String dictType, String dictCode){
		for(Dict d:allDict){
		     if(d.getType().equalsIgnoreCase(dictType)&&d.getCode().equalsIgnoreCase(dictCode)){
		    	 
		    return d;
		     }
		}
		return null;
	}
	
	
	public static String getDictName(String dictType, String dictCode){
		Dict dict = findDictByTypeAndCode(dictType,dictCode);
		if(dict!=null){
			return dict.getName();
		}
		return null;
	}
	
}
