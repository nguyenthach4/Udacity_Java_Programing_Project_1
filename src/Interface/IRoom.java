package Interface;

import enums.RoomType;

/**
 * IRoom.
 *
 * @author NguyenT4
 * @since 2023/08/24
 */
public interface IRoom {

    public String getRoomNumber();

    public Double getRoomPrice();

    public RoomType getRoomType();

    public boolean isFree();
}
