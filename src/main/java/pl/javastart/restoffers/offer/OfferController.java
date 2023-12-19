package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    ResponseEntity<List<OfferDto>> getOffers(@RequestParam(required = false) String title) {
        List<OfferDto> offerList;
        if (title != null) {
            offerList = offerService.findByTitleContaining(title);
        } else {
            offerList = offerService.findAll();
        }
        return ResponseEntity.ok(offerList);
    }

    @GetMapping("/{id}")
    ResponseEntity<OfferDto> getSingleOffer(@PathVariable Long id) {
        Optional<OfferDto> optionalOfferDto = offerService.findById(id);
        return optionalOfferDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/count")
    ResponseEntity<Integer> count() {
        return ResponseEntity.ok(offerService.findAll().size());
    }

    @PostMapping
    ResponseEntity<OfferDto> save(@RequestBody OfferDto offerDto) {
        OfferDto savedOfferDto = offerService.save(offerDto);
        URI savedOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOfferDto.getId())
                .toUri();
        return ResponseEntity.created(savedOfferUri).body(savedOfferDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        offerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
