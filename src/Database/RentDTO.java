package Database;

public class RentDTO {

	//int member_no;
	MemberDTO mDTO = new MemberDTO();
	//int book_no;
	BookDTO bDTO = new BookDTO();
	int confirm;
	
	
	public BookDTO getbDTO() {
		return bDTO;
	}
	public void setbDTO(BookDTO bDTO) {
		this.bDTO = bDTO;
	}
	public int getConfirm() {
		return confirm;
	}
	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
	public MemberDTO getmDTO() {
		return mDTO;
	}
	public void setmDTO(MemberDTO mDTO) {
		this.mDTO = mDTO;
	}
	
	
}
