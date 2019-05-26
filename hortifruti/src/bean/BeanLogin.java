package bean;

public class BeanLogin {

	@SuppressWarnings("unused")
	private String email;
	private Long id;
	private String senha;
	private String addCookie;
	private int count_log;

	public String getEmail(String email) {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddCookie() {
		return addCookie;
	}

	public void setAddCookie(String addCookie) {
		this.addCookie = addCookie;
	}

	public int getCount_log() {
		return count_log;
	}

	public int setCount_log(int count_log) {
		return this.count_log = count_log;
	}

	public String getAddCookie_Session(String addCookie) {
		return this.addCookie = addCookie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
