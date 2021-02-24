package task3;

public class Barrel {
    public final double volume;
    private double currentVolume;
    private Result input = new Result(),output = new Result();

// это конструктор
    public Barrel(double volume, double initiationVolume) {
        this.volume = volume;
        this.currentVolume = initiationVolume;

    }

    public void addLine(double volume){
        (volume > 1 ? input : output).add(volume);              // тернарный оператор
    }
    public double getErrorPercents() {
        if(getTotalAttempsCnt() == 0) {
            return 0;
        }
        return ((double) input.failOfAttemps + (double) output.failOfAttemps) / (double) getTotalAttempsCnt();
    }


    public int getTotalAttempsCnt() {
        return input.numberOfAttemps + output.numberOfAttemps;
    }
    public int getInputCnt() {
        return input.numberOfAttemps;
    }

    public double getInputErrorProcents() {
       return input.failOfAttemps / input.numberOfAttemps;
    }


    public double getTotalImput() {
        return input.successVolume;
    }
    public double getTotalFailInput() {
        return input.failVolume;
    }
    public int getOutputCnt() {
        return output.numberOfAttemps;
    }

    public double getOutputErrorProcents() {
        return (double) output.failOfAttemps / (double) output.numberOfAttemps; // TODO: 21.02.2021 найти ошибку в реализации метода 
    }


    public double getTotalOutput() {
        return output.successVolume;
    }
    public double getTotalFailOutput() {
        return output.failVolume;
    }
    class Result{
        private int numberOfAttemps,  failOfAttemps = 0;
        private double successVolume, failVolume = 0;

        public void add(double addVolume) {
            numberOfAttemps++;
            if( (addVolume >= 0)&(volume - currentVolume > addVolume) | (addVolume < 0)&(volume + addVolume > 0)   ) {
                currentVolume += addVolume;
                successVolume += addVolume;
            }
            else {
                failOfAttemps++;
                failVolume += addVolume;
        }
        }
    }
}
