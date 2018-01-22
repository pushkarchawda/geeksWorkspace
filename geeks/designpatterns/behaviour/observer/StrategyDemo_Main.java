package behaviour.observer;

public class StrategyDemo_Main {

	private static void execute(Strategy strategy) {
        strategy.solve();
    }

    public static void main( String[] args ) {
        Strategy[] algorithms = {new FOO(), new BAR()};
        for (Strategy algorithm : algorithms) {
            execute(algorithm);
        }
    }

}
