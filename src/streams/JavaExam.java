package streams;

enum Level {ASSOCIATE, PROFESSIONAL}
enum Version {JAVA_8, JAVA_11}
public class JavaExam {
    Level lvl;
    Version ver;
    String code;
    public Level getLvl() {
		return lvl;
	}
	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}
	public Version getVer() {
		return ver;
	}
	public void setVer(Version ver) {
		this.ver = ver;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public JavaExam(Level l, Version v, String cd) {lvl=l;ver=v;code=cd;}
    // getters and setters are omitted for brevity
}