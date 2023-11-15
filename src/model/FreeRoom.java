package model;

import constants.AppContant;
import enums.RoomType;

import java.text.MessageFormat;

/**
 * FreeRoom.
 *
 * @author NguyenT4.
 * @since 2023/08/24.
 */
public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, AppContant.DEFAULT_PRICE, enumeration);
    }

    @Override
    public String toString() {
        return MessageFormat.format(AppContant.MessagePattern.FREE_ROOM_INFO,super.toString());
    }
}
