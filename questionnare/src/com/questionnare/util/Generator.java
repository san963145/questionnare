package com.questionnare.util;

import java.util.ArrayList;

import com.questionnare.model.Paper;
import com.questionnare.model.Question;

public class Generator {
	
	public static String generatePaperList(ArrayList<Paper> paperList)
	{		
		StringBuilder s=new StringBuilder();
		s.append("<ul id=\"ulQs\" class=\"survey_list\">");
		int size=paperList.size();
		for(int i=0;i<size;i++){
			Paper paper=paperList.get(i);
			s.append("<li class=\"list_li\" aid=\"");
			s.append(paper.getPaperID());
			s.append("\">");
			s.append("<div class=\"list_li_conent\">");
			s.append("<div class=\"list_text\">");
			s.append(paper.getTitle());
			s.append("</div><div class=\"list_r\"><span class=\"wjNumber\">");
			s.append(paper.getQuestionCount());
			s.append("</span>");
			if(paper.getFinishedCount()==0){
				s.append("</div></div><div style=\"display: none;\" class=\"share_result_menu\" ><ul><li><a href=\"javascript:;\" class=\"sr_list_edit\"><div class=\"icon\"><i class=\"glyphicon glyphicon-pencil\"></i><p class=\"glyphicon_font\"> 编 辑</p></div></a></li><li><a href=\"javascript:;\" class=\"sr_share\" needpub=\"1\"><div class=\"icon\"><i class=\"glyphicon glyphicon-new-window\"></i><p class=\"glyphicon_font\"> 发 布</p></div></a></li><li><a href=\"javascript:;\" class=\"sr_result\"><div class=\"icon\"><i class=\"glyphicon glyphicon-signal\"></i><p class=\"glyphicon_font\"> &nbsp;统 计</p></div></a></li><li><a href=\"javascript:;\" class=\"sr_list_del\"><div class=\"icon\"><i class=\"glyphicon glyphicon-trash\"></i><p class=\"glyphicon_font\"> &nbsp;删 除</p></div></a></li></ul></div></li>");
			}
			else{
				s.append("</div></div><div style=\"display: none;\" class=\"share_result_menu\" ><ul><li><a href=\"javascript:;\" class=\"sr_list_edit\"><div class=\"icon\"><i class=\"glyphicon glyphicon-pencil\"></i><p class=\"glyphicon_font\"> 编 辑</p></div></a></li><li><a href=\"javascript:;\" class=\"sr_share\" needpub=\"1\"><div class=\"icon\"><i class=\"glyphicon glyphicon-new-window\"></i><p class=\"glyphicon_font\"> 发 布</p></div></a></li><li><a href=\"javascript:;\" class=\"sr_result\" count=\"1\"><div class=\"icon\"><i class=\"glyphicon glyphicon-signal\"></i><p class=\"glyphicon_font\"> &nbsp;统 计</p></div></a></li><li><a href=\"javascript:;\" class=\"sr_list_del\"><div class=\"icon\"><i class=\"glyphicon glyphicon-trash\"></i><p class=\"glyphicon_font\"> &nbsp;删 除</p></div></a></li></ul></div></li>");
			}
		}					
        s.append("</ul>");
		return s.toString();
	}
	public static String generateFullPaper(Paper paper,ArrayList<Question>questions)
	{		
		StringBuilder s=new StringBuilder();
		s.append("<fieldset class=\"fieldset\" id=\"fieldset1\">");
		int size=questions.size();
		for(int i=0;i<size;i++){
			Question question=questions.get(i);
			if(question.getType().equals("1")){
				s.append("<div class=\"field ui-field-contain\" id=\"div1\" req=\"1\" topic=\"1\" data-role=\"fieldcontain\" type=\"3\"><div class=\"field-label\">");
				s.append(i+1);
				s.append(".");
				s.append(question.getTitle());
				s.append("<span class=\"req\">*</span></div><div class=\"ui-controlgroup\">");
				if(question.getItemA().length()!=0){
					s.append("<div class=\"ui-radio\"><span class=\"jqradiowrapper\"><input type=\"radio\" value=\"1\" id=\"q1_1\" name=\"q1\" style=\"display:none;\"><a class=\"jqradio\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q1_1\">");
					s.append("A.");
					s.append(question.getItemA());
					s.append("</div></div>");
				}
				if(question.getItemB().length()!=0){
					s.append("<div class=\"ui-radio\"><span class=\"jqradiowrapper\"><input type=\"radio\" value=\"1\" id=\"q1_1\" name=\"q1\" style=\"display:none;\"><a class=\"jqradio\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q1_1\">");
					s.append("B.");
					s.append(question.getItemB());
					s.append("</div></div>");
				}
				if(question.getItemC().length()!=0){
					s.append("<div class=\"ui-radio\"><span class=\"jqradiowrapper\"><input type=\"radio\" value=\"1\" id=\"q1_1\" name=\"q1\" style=\"display:none;\"><a class=\"jqradio\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q1_1\">");
					s.append("C.");
					s.append(question.getItemC());
					s.append("</div></div>");
				}
				if(question.getItemD().length()!=0){
					s.append("<div class=\"ui-radio\"><span class=\"jqradiowrapper\"><input type=\"radio\" value=\"1\" id=\"q1_1\" name=\"q1\" style=\"display:none;\"><a class=\"jqradio\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q1_1\">");
					s.append("D.");
					s.append(question.getItemD());
					s.append("</div></div>");
				}
				if(question.getItemE().length()!=0){
					s.append("<div class=\"ui-radio\"><span class=\"jqradiowrapper\"><input type=\"radio\" value=\"1\" id=\"q1_1\" name=\"q1\" style=\"display:none;\"><a class=\"jqradio\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q1_1\">");
					s.append("E.");
					s.append(question.getItemE());
					s.append("</div></div>");
				}
				if(question.getItemF().length()!=0){
					s.append("<div class=\"ui-radio\"><span class=\"jqradiowrapper\"><input type=\"radio\" value=\"1\" id=\"q1_1\" name=\"q1\" style=\"display:none;\"><a class=\"jqradio\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q1_1\">");
					s.append("F.");
					s.append(question.getItemF());
					s.append("</div></div>");
				}			
				s.append("</div><div class=\"errorMessage\"></div></div>");
			}else{
				s.append("<div class=\"field ui-field-contain\" id=\"div1\" req=\"1\" topic=\"1\" data-role=\"fieldcontain\" type=\"3\"><div class=\"field-label\">");
				s.append(i+1);
				s.append(".");
				s.append(question.getTitle());
				s.append("<span class=\"qtypetip\">&nbsp;[多选题]</span></div><div class=\"ui-controlgroup\">");
				if(question.getItemA().length()!=0){
					s.append("<div class=\"ui-checkbox\"><span class=\"jqcheckwrapper\"><input type=\"checkbox\" value=\"1\" id=\"q2_1\" name=\"q2\" style=\"display:none;\"><a class=\"jqcheck\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q2_1\">");
					s.append("A.");
					s.append(question.getItemA());
					s.append("</div></div>");
				}
				if(question.getItemB().length()!=0){
					s.append("<div class=\"ui-checkbox\"><span class=\"jqcheckwrapper\"><input type=\"checkbox\" value=\"1\" id=\"q2_1\" name=\"q2\" style=\"display:none;\"><a class=\"jqcheck\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q2_1\">");
					s.append("B.");
					s.append(question.getItemB());
					s.append("</div></div>");
				}
				if(question.getItemC().length()!=0){
					s.append("<div class=\"ui-checkbox\"><span class=\"jqcheckwrapper\"><input type=\"checkbox\" value=\"1\" id=\"q2_1\" name=\"q2\" style=\"display:none;\"><a class=\"jqcheck\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q2_1\">");
					s.append("C.");
					s.append(question.getItemC());
					s.append("</div></div>");
				}
				if(question.getItemD().length()!=0){
					s.append("<div class=\"ui-checkbox\"><span class=\"jqcheckwrapper\"><input type=\"checkbox\" value=\"1\" id=\"q2_1\" name=\"q2\" style=\"display:none;\"><a class=\"jqcheck\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q2_1\">");
					s.append("D.");
					s.append(question.getItemD());
					s.append("</div></div>");
				}
				if(question.getItemE().length()!=0){
					s.append("<div class=\"ui-checkbox\"><span class=\"jqcheckwrapper\"><input type=\"checkbox\" value=\"1\" id=\"q2_1\" name=\"q2\" style=\"display:none;\"><a class=\"jqcheck\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q2_1\">");
					s.append("E.");
					s.append(question.getItemE());
					s.append("</div></div>");
				}
				if(question.getItemF().length()!=0){
					s.append("<div class=\"ui-checkbox\"><span class=\"jqcheckwrapper\"><input type=\"checkbox\" value=\"1\" id=\"q2_1\" name=\"q2\" style=\"display:none;\"><a class=\"jqcheck\" href=\"javascript:;\"></a></span><div class=\"label\" for=\"q2_1\">");
					s.append("F.");
					s.append(question.getItemF());
					s.append("</div></div>");
				}			
				s.append("</div><div class=\"errorMessage\"></div></div>");
			}			
		}					
        s.append("</fieldset>");
		return s.toString();
	}
	

}
