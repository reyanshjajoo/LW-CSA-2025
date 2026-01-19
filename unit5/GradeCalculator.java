public class GradeCalculator {
    public class Grades {
        private double GPA;
        private double weightedGPA;
        private int classCount;

        /**
         * Constructor to initialize GPA, weighted GPA, and class count.
         * 
         * @param GPA         Initial GPA
         * @param weightedGPA Initial weighted GPA
         * @param classCount  Initial class count
         */
        public Grades(double GPA, double weightedGPA, int classCount) {
            this.GPA = GPA;
            this.weightedGPA = weightedGPA;
            this.classCount = classCount;
        }

        /**
         * Get the current GPA.
         * 
         * @return GPA
         */
        public double getGPA() {
            return this.GPA;
        }

        /**
         * Get the current weighted GPA.
         * 
         * @return Weighted GPA
         */
        public double getWeightedGPA() {
            return this.weightedGPA;
        }

        /**
         * Get the current class count.
         * 
         * @return Class count
         */
        public int getClassCount() {
            return this.classCount;
        }

        /**
         * Add a new class grade and update GPA and weighted GPA.
         * 
         * @param grade The grade of the new class
         * @param isAP  Whether the class is an AP class
         */
        public void addClass(double grade, boolean isAP) {
            double totalPoints = GPA * classCount;
            double totalWeightedPoints = weightedGPA * classCount;

            totalPoints += grade;
            if (isAP) {
                totalWeightedPoints += grade + 1.0;
            } else {
                totalWeightedPoints += grade;
            }

            this.classCount += 1;

            this.GPA = totalPoints / classCount;
            this.weightedGPA = totalWeightedPoints / classCount;

            this.GPA = Math.round(GPA * 100.0) / 100.0;
            this.weightedGPA = Math.round(weightedGPA * 100.0) / 100.0;
        }

        /**
         * String representation of the Grades object
         */
        @Override
        public String toString() {
            return "GPA: " + GPA + ", Weighted GPA: " + weightedGPA + ", Class Count: " + classCount;
        }
    }

    public static void main(String[] args) {
        Grades grades = new GradeCalculator().new Grades(3.5, 3.7, 4);

        // Expected output:
        /*
         * GPA: 3.5, Weighted GPA: 3.7, Class Count: 4;
         */
        System.out.println(grades.toString() + "\n");

        grades.addClass(3.9, true);

        // Expected output:
        /*
         * After adding AP class with grade 3.9:
         * GPA: 3.58, Weighted GPA: 3.94, Class Count: 5;
         */
        System.out.println("After adding AP class with grade 3.9:");
        System.out.println(grades.toString() + "\n");

        grades.addClass(2.3, false);

        // Expected output:
        /*
         * After adding regular class with grade 2.3:
         * GPA: 3.37, Weighted GPA: 3.67, Class Count: 6;
         */
        System.out.println("After adding regular class with grade 2.3:");
        System.out.println(grades.toString());
    }
}
