public class Clock {
   private int hours, minutes, seconds;

   public Clock(int hours, int minutes, int seconds) {
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
   }

   public void setHours(int hours) {
      this.hours = hours;
   }

   public void setMinutes(int minutes) {
      this.minutes = minutes;
   }

   public void setSeconds(int seconds) {
      this.seconds = seconds;
   }

   public int getHours() {
      return hours;
   }

   public int getMinutes() {
      return minutes;
   }

   public int getSeconds() {
      return seconds;
   }

   public String toString() { 
	   String hoursInText = Integer.toString(hours), minutesInText = Integer.toString(minutes), secondsInText = Integer.toString(seconds);
	   if(hoursInText.length() == 1) hoursInText = '0' + hoursInText;
	   if(minutesInText.length() == 1) minutesInText = '0' + minutesInText;
	   if(secondsInText.length() == 1) secondsInText = '0' + secondsInText;
	   return hoursInText + ":" + minutesInText + ":" + secondsInText;
   }
}
