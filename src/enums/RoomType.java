package enums;

/**
 * RoomType.
 *
 * @author NguyenT4
 * @since 2023/08/24
 */
public enum RoomType {
  SINGLE("1"),
  DOUBLE("2");

  private final String type;

  private RoomType(String type) {

    this.type = type;
  }

  public String valueOfRoomType(String type) {
    return this.type;
  }
}
