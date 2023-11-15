package model;

import Interface.IRoom;
import constants.AppContant;
import enums.RoomType;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Room.
 *
 * @author NguyenT4.
 * @since 2023/08/24
 */
public class Room implements IRoom {

  /**
   * RoomNumber.
   */
  private final String roomNumber;

  /**
   * Price.
   */
  private final Double price;

  /**
   * Enumeration.
   */
  private RoomType enumeration;

  public Room(String roomNumber, Double price, RoomType enumeration) {
    this.roomNumber = roomNumber;
    this.price = price;
    this.enumeration = enumeration;
  }

  @Override
  public String getRoomNumber() {
    return this.roomNumber;
  }

  @Override
  public Double getRoomPrice() {
    return this.price;
  }

  @Override
  public RoomType getRoomType() {
    return this.enumeration;
  }

  @Override
  public boolean isFree() {
    return Objects.nonNull(this.price) && Objects.equals(AppContant.DEFAULT_PRICE, this.price);
  }

  @Override
  public String toString() {
    return MessageFormat.format(AppContant.MessagePattern.ROOM_INFO, this.roomNumber, this.price, this.enumeration);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    
    if (obj instanceof Room) {
      final Room room = (Room) obj;
      return Objects.equals(this.roomNumber, room.roomNumber);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(roomNumber);
  }
}
