
public class Reservation {
        private String date;
        private String time;
        private String serviceType;
        private String stylist;
        private String clientName;
        private String phoneNum;
        private String email;

        public Reservation(String date, String time, String serviceType, String stylist, String clientName, String phoneNum, String email) {
            this.date = date;
            this.time = time;
            this.serviceType = serviceType;
            this.stylist = stylist;
            this.clientName = clientName;
            this.phoneNum = phoneNum;
            this.email = email;
            
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public String getServiceType() {
            return serviceType;
        }

        public String getClientName() {
            return clientName;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public String getEmail() {
            return email;
        }
        
        public String getStylist(){
            return stylist;
        }

        @Override
        public String toString() {
            return "Reservation Details:\n" +
                    "Client Name: " + clientName + "\n" +
                    "Phone Number: " + phoneNum + "\n" +
                    "Email: " + email + "\n" +
                    "Date: " + date + "\n" +
                    "Time: " + time + "\n" +
                    "Service Type: " + serviceType + "\n" +
                    "Stylist Name: " + stylist;
        }
    }
