import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Room } from './model/room.model';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private apiUrl="backend api"

  constructor(private http: HttpClient )  { }

  checkRoomAvailability(checkInDate:string,checkOutDate:string): Observable<Room>{
     const url="${this.apiUrl}+the api path";

     const payload={
      checkIn:checkInDate,
      checkOut:checkOutDate
     }
     return this.http.post<Room>(url,payload);
  }
}
