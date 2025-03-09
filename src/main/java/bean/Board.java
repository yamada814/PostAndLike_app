package bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Board implements Serializable{
	private Integer id;
	private String mydate;
	private String loginId;
	private String contents;
	private Integer likes;
	public Board() {}
	
	public Board(Integer id, Date mydate, String loginId,String contents, Integer likes) {
		super();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
		this.id = id;
		if (mydate!=null) {
			this.mydate = f.format(mydate);
		} else {
			this.mydate =null;
		}
		this.loginId = loginId;
		this.likes = likes;
		this.contents = contents;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
		
		this.mydate = f.format(mydate);
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getContents() {
		return sanitize(contents);
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
    public static String sanitize(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sanitized = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    sanitized.append("&lt;");
                    break;
                case '>':
                    sanitized.append("&gt;");
                    break;
                case '&':
                    sanitized.append("&amp;");
                    break;
                case '"':
                    sanitized.append("&quot;");
                    break;
                case '\'':
                    sanitized.append("&#39;");
                    break;
                default:
                    sanitized.append(c);
                    break;
            }
        }
        return sanitized.toString();
    }

	@Override
	public String toString() {
		return "Board [id=" + id + ", mydate=" + mydate + ", loginId=" + loginId + ", contents=" + contents + ", likes="
				+ likes + "]";
	}
    

}
