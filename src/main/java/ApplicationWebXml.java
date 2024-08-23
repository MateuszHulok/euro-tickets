import euro.tickets.EuroTicketsApplication;
import io.github.jhipster.config.DefaultProfileUtil;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ApplicationWebXml extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder appBuilderilder) {
        DefaultProfileUtil.addDefaultProfile(appBuilderilder.application());
        return appBuilderilder.sources(EuroTicketsApplication.class);
    }
}
