import { Component } from '@angular/core';
import { Room } from '../model/room.model';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-check-availability',
  templateUrl: './check-availability.component.html',
  styleUrls: ['./check-availability.component.css']
})
export class CheckAvailabilityComponent {
  checkInDate: string ;
  checkOutDate: string ;
  availableRoom: any =null;
  noRoomAvailable: boolean = false;

  constructor(private roomService:RoomService){}

  checkAvailibility(){
    this.roomService.checkRoomAvailability(this.checkInDate,this.checkOutDate).subscribe(
      (room:Room)=>{
        this.availableRoom=room;
        this.noRoomAvailable=!room;
      },
      error=>{
        console.log(error);
        this.noRoomAvailable=true; 
      }
    )
  }

  bookRoom(){
    //booking function
  }
}
