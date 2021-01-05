package ppp.notemappp.models;

import java.io.Serializable;

public class Fields implements Serializable {
        private Float temp;
        private Float feels_like;
        private Float pressure;
        private Float humidity;


        public Float getTemp() {
                return temp;
        }

        public void setTemp(Float temp) {
                this.temp = temp;
        }

        public Float getFeels_like() {
                return feels_like;
        }

        public void setFeels_like(Float feels_like) {
                this.feels_like = feels_like;
        }

        public Float getPressure() {
                return pressure;
        }

        public void setPressure(Float pressure) {
                this.pressure = pressure;
        }

        public Float getHumidity() {
                return humidity;
        }

        public void setHumidity(Float humidity) {
                this.humidity = humidity;
        }
}
