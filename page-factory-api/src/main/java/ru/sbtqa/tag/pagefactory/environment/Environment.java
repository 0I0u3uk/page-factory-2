package ru.sbtqa.tag.pagefactory.environment;

import ru.sbtqa.tag.pagefactory.actions.PageActions;
import ru.sbtqa.tag.pagefactory.checks.PageChecks;
import ru.sbtqa.tag.pagefactory.drivers.DriverService;
import ru.sbtqa.tag.pagefactory.reflection.Reflection;

/**
 * Static storage for infrastructure
 */
public class Environment {

    static InheritableThreadLocal<DriverService> driverService = new InheritableThreadLocal<DriverService>();
    static ThreadLocal<PageActions> pageActions = new ThreadLocal<>();
    static ThreadLocal<PageChecks> pageChecks = new ThreadLocal<>();
    static ThreadLocal<Reflection> reflection = new ThreadLocal<>();

    public static void setDriverService(DriverService driverService) {
        Environment.driverService.set(driverService);
    }

    public static DriverService getDriverService() {
        return driverService.get();
    }

    public static boolean isDriverEmpty() {
        return driverService.get() == null || driverService.get().isDriverEmpty();
    }

    public static PageActions getPageActions() {
        return pageActions.get();
    }

    public static void setPageActions(PageActions pageActions) {
        Environment.pageActions.set(pageActions);
    }

    public static PageChecks getPageChecks() {
        return pageChecks.get();
    }

    public static void setPageChecks(PageChecks pageChecks) {
        Environment.pageChecks.set(pageChecks);
    }

    public static Reflection getReflection() {
        return reflection.get();
    }

    public static void setReflection(Reflection reflection) {
        if (Environment.reflection.get() == null || !reflection.getClass().isAssignableFrom(Environment.reflection.get().getClass())) {
              Environment.reflection.set(reflection);
        }
    }
}
