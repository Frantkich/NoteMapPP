package ppp.notemappp.models;

import java.io.Serializable;

public class Fields implements Serializable {
        private Float temp;
        private Float feels_like;
        private Float pressure;
        private Float humidity;

        public String getTemp() {
                return String.valueOf(temp);
        }

        public void setTemp(Float temp) {
                this.temp = temp;
        }

        public String getFeels_like() {
                return String.valueOf(feels_like);
        }

        public void setFeels_like(Float feels_like) {
                this.feels_like = feels_like;
        }

        public String getPressure() {
                return String.valueOf(pressure);
        }

        public void setPressure(Float pressure) {
                this.pressure = pressure;
        }

        public String getHumidity() {
                return String.valueOf(humidity);
        }

        public void setHumidity(Float humidity) {
                this.humidity = humidity;
        }
}
