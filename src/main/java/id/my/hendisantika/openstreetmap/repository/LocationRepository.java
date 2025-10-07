package id.my.hendisantika.openstreetmap.repository;

import id.my.hendisantika.openstreetmap.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-open-street-map
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 07/10/25
 * Time: 15.30
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
