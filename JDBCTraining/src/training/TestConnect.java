package training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String[] args) {
		String sql = "insert into course values(?, ?, ?, ?, ?)";
		String sqlCount = "select max(course_id)+1 from course";
		Connection conn = DBUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlCount);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString(1);

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, "VNO");
				pstmt.setString(3, "9999");
				pstmt.setString(4, "Tư tưởng HCM");
				pstmt.setInt(5, 9);

				int check = pstmt.executeUpdate();
				System.out.println(rs);
				if (check > 0) {
					System.out.println("Thành công");
				} else {
					System.out.println("Thất bại");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
